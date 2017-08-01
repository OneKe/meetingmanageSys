package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.service.RoleService;
import com.chinasofti.mms.util.TransferUtil;


@Controller
public class NewPasswordController {
	
	@Autowired
	private RoleService service;
	
	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}
	
	TransferUtil mdu = new TransferUtil();
	
	@RequestMapping("changepassword.action")
	public ModelAndView changePassword(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		/*
		 * 从登陆回话中拿到登陆用户名
		 */
		HttpSession session = request.getSession();
		String loginUserName = (String)session.getAttribute("loginUserName");
		
		/*
		 * 判断用户是否登陆，未登录就跳转到登陆页面
		 */
		if(null == loginUserName || "".equals(loginUserName)){
			request.setAttribute("message", "请登录！");
			mv.setViewName("login");
			return mv;
		}
		/*
		 * 从页面上拿到输入的原始密码，新密码，确认密码
		 */
		String originpassword =  request.getParameter("originpassword");
		String oldpwd = mdu.getMD5(originpassword);
		String newpassword =  request.getParameter("newpassword");
		String newpwd = mdu.getMD5(newpassword);
		String confirmpassword = request.getParameter("confirmpassword");
		String confirmpwd = mdu.getMD5(confirmpassword);
		
		/*
		 * 原始密码，新密码，确认密码 有一个没有输入刷新页面重新输入
		 */
		if(null == originpassword || null == newpassword ||null  == confirmpassword || 
				"".equals(originpassword) || "".equals(newpassword) || "".equals(confirmpassword)){
			mv.addObject("message", "输入错误,请再次输入！");
			mv.setViewName("changepassword");
			return mv;
		}
		
		/*
		 * 新密码和确认密码不一致，重新输入。一致的话，将新数据写入到数据库
		 */
		if(!newpwd.equals(confirmpwd)){
			mv.addObject("message", "两次密码输入不一致！");
			mv.setViewName("changepassword");
			return mv;
		}else if(newpwd.equals(originpassword)){
			mv.addObject("message", "新密码与原始密码一致，请重新输入！");
			mv.setViewName("changepassword");
			return mv;
		}else{
			int isChanged = service.updateNewPassword(loginUserName,oldpwd,newpwd);
			if(0 == isChanged){
				mv.addObject("message", "原密码有误，修改失败！");
				mv.setViewName("changepassword");
				return mv;
			}else{
				mv.addObject("message", "修改成功！");
				mv.setViewName("forward:loginoff.action");
				return mv;
			}
		}
	}
}
