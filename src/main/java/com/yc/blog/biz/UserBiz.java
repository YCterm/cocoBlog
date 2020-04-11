package com.yc.blog.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.yc.blog.bean.User;
import com.yc.blog.bean.UserExample;
import com.yc.blog.dao.UserMapper;
import com.yc.blog.utils.MD5Util;
import com.yc.blog.utils.VerificationCodeUtil;

@Service
public class UserBiz {

	@Resource
	private UserMapper um;

	@Autowired
	private JavaMailSender javaMailSender;

	// 发件人的邮箱地址
	@Value("${mail.sender.addr}")
	private String senderAddr;

	
	/**
	 * 登录
	 * 
	 * @param user 登录的用户
	 * @return
	 * @throws BizException
	 */
	public User loginUser(User user) throws BizException {
		MD5Util objMD5Util = new MD5Util();
		UserExample userExample = new UserExample();
		// 判断用户名和密码是否合法
		userExample.createCriteria().andUnammeEqualTo(user.getUnamme()).andPassswordEqualTo(objMD5Util.MD5(user.getPasssword())).
		andNicknameEqualTo(user.getUnamme()).andPassswordEqualTo(objMD5Util.MD5(user.getPasssword()));

		// 存放从数据库中查找到的登录用户的信息
		List<User> listuser = um.selectByExample(userExample);
		System.out.println("listuser" + listuser);
		if (listuser.size() == 0) {
			throw new BizException("用户名或密码不正确，请确认后输入！");
		} else {
			user = listuser.get(0);
			user.setPasssword("");
			System.out.println(user);
			return listuser.get(0);
		}

	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 * @throws BizException
	 */
	public boolean reg(User user) throws BizException {
		try {
			um.insert(user);
			return true;
		} catch (Exception e) {
			throw new BizException("失败！",e);
		}

	}

	/**
	 * 判断用户名是否被注册
	 * 
	 * @param unamme
	 * @return
	 * @throws BizException
	 */
	public boolean validation(String unamme) throws BizException {
		try {
			UserExample userexample = new UserExample();
			userexample.createCriteria().andUnammeEqualTo(unamme);
			if (um.selectByExample(userexample).size() == 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new BizException("业务繁忙！");
		}
	}

	/**
	 * 验证用户名和邮箱信息是否合法
	 * @param user
	 * @param email
	 * @return
	 * @throws BizException
	 */
	public boolean userAndEmaiIsValid(String user, String uemail) throws BizException {
		if (user.equals("Your Full Name")) {
			throw new BizException("请输入用户名");
		}
		if (uemail.equals("Email@address.com")) {
			throw new BizException("请输入邮箱地址");
		}
		UserExample userexample = new UserExample();
		userexample.or().andUnammeEqualTo(user).andUemailEqualTo(uemail);
		userexample.or().andUphoneEqualTo(user).andUemailEqualTo(uemail);
		userexample.or().andUemailEqualTo(user).andUemailEqualTo(uemail);
		List<User> listUser = um.selectByExample(userexample);
		if (listUser.size() == 0) {
			throw new BizException("您输入的账号不存在，请查验后再重新填写");
		}
		return true;
	}

	/**
	 * 重置密码
	 * @param user
	 * @param uemail
	 * @param verificationCode
	 * @param passsword
	 * @param repasssword
	 * @param orginalUser
	 * @param reallyVerificationCode
	 * @param objValidTime
	 * @param presentTime
	 * @throws BizException
	 */
	public void resetPasswordInfoValid(String user, String uemail, String verificationCode, String passsword,
			String repasssword, String orginalUser, String reallyVerificationCode, Date objValidTime,
			Date presentTime) throws BizException {
		if(!orginalUser.equals(user)) {
			throw new BizException("用户名信息被修改，请重新输入正确的用户名");
		}
		if(!reallyVerificationCode.equals(verificationCode)) {
			throw new BizException("验证码输入错误，请重新输入");
		}
		if(!passsword.equals(repasssword)) {
			throw new BizException("两次密码输入不一致，请确认后重新输入");
		}
		if(!objValidTime.after(presentTime)) {
			throw new BizException("验证码已经失效,请重新获取验证码");
		}
		resetPassword(user,passsword,uemail);
	}
	/**
	 * 重置密码的相关信息校验
	 * @param user
	 * @param passsword
	 * @param uemail
	 */
	private void resetPassword(String user, String passsword, String uemail) {
		UserExample userExample=new UserExample();
		userExample.or().andUnammeEqualTo(user).andUemailEqualTo(uemail);
		userExample.or().andUemailEqualTo(user).andUemailEqualTo(uemail);
		User objUser=new User();
		MD5Util objMD5Util=new MD5Util();
		String strPasswordByMD5=objMD5Util.MD5(passsword);
		objUser.setPasssword(strPasswordByMD5);
		um.updateByExampleSelective(objUser, userExample);
		
	}

	/**
	 * 发送验证码函数
	 * 
	 * @param ueamil 邮件地址
	 * @return strVerificationCode 验证码
	 */
	public String sendVerificationCode(String uemail) {
		// 获取验证码工具类
		VerificationCodeUtil objVerificationCodeUtil = new VerificationCodeUtil();

		SimpleMailMessage objSimpleMailMessage = new SimpleMailMessage();

		objSimpleMailMessage.setFrom(senderAddr);

		objSimpleMailMessage.setTo(uemail);

		objSimpleMailMessage.setSubject("CocoBlog用户登录密码找回");
		// 获取验证码
		String strVerificationCode = objVerificationCodeUtil.generateVerificationCode();

		objSimpleMailMessage.setText("您的找回密码的验证码为： " + strVerificationCode + " (有效时间为3分钟)，请勿将该验证码告诉任何人！");

		javaMailSender.send(objSimpleMailMessage);

		return strVerificationCode;
	}

	

/**
 * 判断是否修改密码以及修改密码是否成功
 * @param logineduser  登录用户的信息
 * @param check
 * @param newPassword	新密码
 * @param repasssword	确认新密码
 * @param oldPassword	原密码
 * @return
 * @throws BizException
 */
	public boolean updatePasssword(User logineduser,String newPassword,
			String repasssword,String oldPassword) throws BizException {
		UserExample userExample= new UserExample();
		MD5Util objMD5Util = new MD5Util();
		
			logineduser=um.selectByPrimaryKey(logineduser.getUid());
			if(	 ! logineduser.getPasssword().equals(objMD5Util.MD5(oldPassword))) {
				throw new BizException("原密码输入错误，请认真核对后输入！");
			}else {
			/*
			 * if(oldPassword.equals(newPassword)) { throw new
			 * BizException("原密码与新密码输入一致，请重新输入！"); }else {
			 */
					if(  ! newPassword.equals(repasssword) ) {
						throw new BizException("输入的两次新密码不一致，请仔细核对后输入");
					}
					System.out.println("进入修改密码");
					User user = new User();
					user.setPasssword(objMD5Util.MD5(newPassword));
					user.setUid(logineduser.getUid());
					um.updateByPrimaryKeySelective(user);
					return true;
				}
		/* } */
		
	}

	/**
	 * 修改邮箱
	 * @param logineduser
	 * @param uemail
	 * @return
	 */
	public boolean updateUemail(User logineduser,String uemail) {
		if(uemail==null || uemail.trim().equals("")) {
			return false;
		}else {
			User user = new User();
			user.setUid(logineduser.getUid());
			user.setUemail(uemail);
			um.updateByPrimaryKeySelective(user);
			return true;
		}
	}

	/**
	 * 修改电话
	 * @param logineduser
	 * @param uphone
	 * @return
	 */
	public boolean updateUphone(User logineduser,String uphone) {
		if(uphone==null || uphone.trim().equals("")) {
			return false;
		}else {
			User user = new User();
			user.setUid(logineduser.getUid());
			user.setUphone(uphone);
			um.updateByPrimaryKeySelective(user);
			return true;
		}
	}
	/**
	 * 上传图片
	 * @param logineduser
	 * @param head
	 * @return
	 */
	public boolean updateHead(User logineduser,String head) {
		/*
		 * if(head==null) { return false; }else {
		 */
			User user = new User();
			user.setUid(logineduser.getUid());
			user.setHead(head);
			System.out.println("head+++++"+user.getHead());
			um.updateByPrimaryKeySelective(user);
			return true;
		/* } */
	}
	/**
	 * 修改用户名
	 * @param logineduser
	 * @param unamme
	 * @return
	 */
	public boolean updateUnamme(User logineduser,String unamme) {
		if(unamme==null || unamme.trim().equals("")) {
			return false;
		}else {
			User user = new User();
			user.setUid(logineduser.getUid());
			user.setUnamme(unamme);
			um.updateByPrimaryKeySelective(user);
			return true;
		}
	}
	/**
	 * 修改昵称
	 * @param logineduser
	 * @param nickname
	 * @return
	 */
	public boolean updateNickname(User logineduser,String nickname) {
		if(nickname==null || nickname.trim().equals("")) {
			return false;
		}else {
			User user = new User();
			user.setUid(logineduser.getUid());
			user.setNickname(nickname);
			um.updateByPrimaryKeySelective(user);
			return true;
		}
	}

	
}
