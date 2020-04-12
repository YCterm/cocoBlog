package com.yc.blog.web.hyq;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.yc.blog.bean.User;
import com.yc.blog.bean.UserExample;
import com.yc.blog.biz.BizException;
import com.yc.blog.biz.UserBiz;
import com.yc.blog.dao.UserMapper;
import com.yc.blog.utils.MD5Util;
import com.yc.blog.utils.ThumbnailatorUtil;
import com.yc.blog.vo.Result;
import com.yc.blog.web.tml.IndexAction;

@Controller
@SessionAttributes("loginedUser")
public class UserAction {

	@Resource
	private UserBiz ubiz;

	@Resource
	private UserMapper um;

	/*
	 * @GetMapping("login.html") public String dologin() { return "login"; }
	 */
		@GetMapping("login.html")
		public ModelAndView dologin(ModelAndView mav) {
			mav.setViewName("login");
			return mav;
		}
		
	@GetMapping("signup.html")
	public String tosignup() {

		return "signup";
	}

	@GetMapping("forget.html")
	public String forget() {
		return "forget";
	}
	
	
	
	  @GetMapping("person.html") 
	  public ModelAndView person(ModelAndView mav) { 
		  mav.setViewName("person");
			return mav;
	  }
	/**
	 * 登录
	 * 
	 * @param user
	 * @param mav
	 * @return
	 */
	@PostMapping("dologin")
	public String dologin(User user,ModelMap md,HttpSession session) {
		try {
			// 获取ubiz中已登录的用户信息
			User us = ubiz.loginUser(user);
			session.setAttribute("loginedUser", us);
			return "redirect:index";
		} catch (BizException e) {
			e.printStackTrace();
			md.addAttribute("msg",e.getMessage());
			return "login";
		}		
	}



	/**
	 * 验证用户名是否被注册
	 * 
	 * @param unamme 用户名
	 * @return
	 */
	@PostMapping("doname")
	@ResponseBody
	public Result validation(@RequestParam String unamme) {
		try {
			if (ubiz.validation(unamme)) {
				return new Result(1, unamme);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0, unamme);
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("doreg")
	@ResponseBody
	public Result doreg(User user) {
		String pwd = new MD5Util().MD5(user.getPasssword());
		user.setPasssword(pwd);
		try {
			if (ubiz.reg(user)) {
				return new Result(1, "注册成功");
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0, "注册失败");
	}

	/**
	 * 发送验证码邮件
	 * @param user
	 * @param uemail
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("getVerificationCode")
	@ResponseBody
	public Result getVerificationCode(String user, String uemail, HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().invalidate();
		System.out.println(user);
		System.out.println(uemail);
		try {
			if (ubiz.userAndEmaiIsValid(user, uemail)) {
				String strVerificationCode = ubiz.sendVerificationCode(uemail);
				System.out.println("验证码是========" + strVerificationCode);
				// 向session插入验证码，用于和用户输入的验证码进行比对
				httpServletRequest.getSession().setAttribute("verificationCode", strVerificationCode);
				httpServletRequest.getSession().setAttribute("validTime",
						new Date(System.currentTimeMillis() + 3 * 60 * 1000));
				httpServletRequest.getSession().setAttribute("orginalUser", user);
				// 1代表成功
				return new Result(1, "验证码已发送，请及时查收！", null);
			}
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2, e.getMessage(), null);
		}
		return null;
	}
	/**
	 * 重置密码
	 * @param user
	 * @param uemail
	 * @param verificationCode
	 * @param passsword
	 * @param repasssword
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("repassword")
	@ResponseBody
	public Result resetPassword(String user, String uemail, String verificationCode, String passsword,
			String repasssword, HttpServletRequest httpServletRequest) {
		System.out.println("user=" + user);
		System.out.println("uemail" + uemail);
		System.out.println("verificationCode====" + verificationCode);
		System.out.println("passsword" + passsword);
		System.out.println("repasssword" + repasssword);
		// 在session中取出 获取验证码的用户名，验证码，有效时间
		String strOrginalUser = String.valueOf(httpServletRequest.getSession().getAttribute("orginalUser"));
		String strReallyVerificationCode = String
				.valueOf(httpServletRequest.getSession().getAttribute("verificationCode"));
		Date objValidTime = (Date) httpServletRequest.getSession().getAttribute("validTime");
		try {
			ubiz.resetPasswordInfoValid(user, uemail, verificationCode, passsword, 
					repasssword, strOrginalUser,strReallyVerificationCode, 
					objValidTime, new Date(System.currentTimeMillis()));
			return new Result(1,"修改成功，3s后跳转登录页面",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),null);
		}
	}
	/**
	 * 修改个人信息
	 * @param user			会话中登录用户信息
	 * @param uemail  		邮件
	 * @param unamme		用户名
	 * @param nickname		昵称
	 * @param uphone		电话	
	 * @param originalPassword		原密码
	 * @param confirmNewPassword	确认新密码
	 * @param newPassword			新密码
	 * @param head					头像
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("updateInfo")
	@ResponseBody
	public Result updateInfo(@SessionAttribute("loginedUser") User user, String uemail,String unamme,String nickname, 
			String uphone,String originalPassword, String confirmNewPassword, String newPassword,
			MultipartFile head,HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException, BizException {
	
		//获取文件名
		String strFilename=head.getOriginalFilename();
		//原文件存储路径
		File OriginalFile = new File("c:/coco/originalImg");
		if( !OriginalFile.exists()) {
			OriginalFile.mkdirs();
		}
		File ProfileFile = new File("c:/coco/new");
		if( !ProfileFile.exists()) {
			ProfileFile.mkdirs();
		}
		//获取磁盘路径
		String strDiskPath = "c:/coco/originalImg/"+strFilename;
		
		System.out.println("上传图片路径===="+strDiskPath);

		//以磁盘路径创建文件
		File objFile = new File(strDiskPath);
		head.transferTo(objFile);
		System.out.println("文件名===="+objFile);
		//使用ThumbnailatiorUtil工具类 进行图片的像素(50*50）压缩
		ThumbnailatorUtil objThumbnailatorUtil =new ThumbnailatorUtil();
		//创建文件夹存放压缩后的图片
		String strProfileDiskPath = "c:/coco/new/"+strFilename;
		System.out.println("保存图片路径===="+strProfileDiskPath);
		objThumbnailatorUtil.changeImgSize(strDiskPath, strProfileDiskPath);
		
		ubiz.updateUnamme(user, unamme);
		ubiz.updateNickname(user, nickname);
		
		/*
		 * ubiz.updatePasssword(user,newPassword,confirmNewPassword, originalPassword);
		 */
		ubiz.updateUphone(user, uphone);
		ubiz.updateUemail(user, uemail);
		
		ubiz.updateHead(user, strFilename);
		
		return new Result(1, "信息修改成功", null);
	}
	@PostMapping("passwordInfo")
	@ResponseBody
	public Result passwordInfo(@SessionAttribute("loginedUser") User user,String originalPassword, String confirmNewPassword, String newPassword,
			MultipartFile head,HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException{
		 try {
			ubiz.updatePasssword(user,newPassword,confirmNewPassword, originalPassword);
			return new Result(1, "信息修改成功", null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2, e.getMessage(), null);
		}
	}
	/**
	 * @author Hooy
	 * 修改个人资料页面原始信息自动填充
	 */
	@PostMapping("getUserInfo")
	@ResponseBody
	public Result getUserInfo(@SessionAttribute("loginedUser") User user) {
		//获取当前用户的账号
		String uname = user.getUnamme();
		UserExample ue = new UserExample();
		ue.createCriteria().andUnammeEqualTo(uname);
		List<User> userList = um.selectByExample(ue);
		if(userList.size() < 1) {
			return new Result(0,"请先登录",null);
		}
		User loginedUser = userList.get(0);	
		return new Result(1,"加载成功",loginedUser);
	}

}
