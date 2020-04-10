package com.yc.blog.web.psq;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.blog.bean.Links;
import com.yc.blog.biz.BackLinkBiz;
import com.yc.blog.biz.BizException;
import com.yc.blog.vo.Result;

@Controller
public class BackLinksAction {
	@Resource
	private BackLinkBiz blb;

	/**
	 * 查询所有链接
	 */
	@GetMapping("backLinks")
	public String selectAll(Model m) {
		try {
			m.addAttribute("linklist",blb.selectAllLinks());
		} catch (BizException e) {
			e.printStackTrace();
		}
		return "back/link";
	}
	/**
	 * 修改链接状态
	 */
	@PostMapping("changeFstatus")
	@ResponseBody
	public Result changeFstatus(String fstate, String fid,Model m) {
		try {
				if(fstate != null && !fstate.isEmpty() && fid != null && !fid.isEmpty()) {
					Links links = new Links();
					links.setFid(Integer.parseInt(fid));
					links.setFstatus(Integer.parseInt(fstate));
					if(blb.updateFstatus(links) > 0 ) {
						m.addAttribute("linklist",blb.selectAllLinks());
						return new Result(0,"修改成功！！！");
					}else {
						return new Result(1000,"修改失败！！！");
					}
				}else {
					return new Result(1001,"数据为空！！！");
				}
		} catch (BizException e) {
			e.printStackTrace();
			return e.getResult();
		}
	}
	/**
	 * 验证链接名
	 */
	@PostMapping("checkFname")
	@ResponseBody
	public Result checkFname(String fname) {
		//链接名正则：中文、英文、数字包括下划线等字符
		String regFname = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";
		if(fname != null && !fname.isEmpty()) {
			if(!fname.matches(regFname)) {
				return  new Result(1003,"请输入中文、英文或数字！！！");
			}
			return new Result(0,"输入正确！！！");
		}else {
			return new Result(1001,"数据为空！！！");
		}
	}
	/**
	 * 验证链接地址
	 */
	@PostMapping("checkFurl")
	@ResponseBody
	public Result checkFurl(String furl) {
		//链接名正则：
		String regFurl = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if(furl != null && !furl.isEmpty()) {
			if(!furl.matches(regFurl)) {
				return  new Result(1003,"请输入合法地址！！！");
			}
			return new Result(0,"输入正确！！！");
		}else {
			return new Result(1001,"数据为空！！！");
		}
	}
	/**
	 * 更新链接信息
	 */
	@PostMapping("updateLink")
	@ResponseBody
	public Result updateLink(String fname,String furl,String fstate,String fid,Model m){
		if(fid != null && !fid.isEmpty()) {
			Links links = new Links();
			if(furl != null && !furl.isEmpty()) {
				links.setFurl(furl);
			}
			if(fname != null && !fname.isEmpty()) {
				links.setFname(fname);
			}
			if(fid != null && !fid.isEmpty()) {
				links.setFid(Integer.parseInt(fid));
			}
			if(fstate != null && !fstate.isEmpty()) {
				links.setFstatus(Integer.parseInt(fstate));
			}
			try {
				if(blb.updateLink(links) > 0 ) {
					m.addAttribute("linklist",blb.selectAllLinks());
					return new Result(0,"更新成功！！！");
				}
				return new Result(1000,"更新失败！！！");
			} catch (BizException e) {
				e.printStackTrace();
				return e.getResult();
			}
		}else {
			return new Result(1002,"未选择任何友情链接！！！");
		}
	}
}
