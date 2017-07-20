package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.service.DepartmentService;



@Controller
public class DepartmentController {
    private DepartmentService dservice;
    
	public DepartmentService getDservice() {
		return dservice;
	}

	public void setDservice(DepartmentService dservice) {
		this.dservice = dservice;
	}

	/*
	 * 添加部门
	 */
	@RequestMapping("/adddepartmen.action")
	public ModelAndView ManageDepartment(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		ModelAndView mav = new ModelAndView();
		String departmentName = request.getParameter("departmentname");
		if(null == departmentName || "".equals(departmentName)){
			request.setAttribute("message", "部门名为空！");
			mav.setViewName("departments");
			return mav;
		}
		boolean isUsed = dservice.testDepartmentName(departmentName);
		if(isUsed == true){
			request.setAttribute("message", "部门名重复！");
			mav.setViewName("departments");
			return mav;
		}else{
			boolean isAdded = dservice.addDepartment(departmentName);
			if(isAdded){
				request.setAttribute("message", "添加部门成功！");
				mav.setViewName("departments");
				return mav;
			}else{
				request.setAttribute("message", "添加部门失败！");
				mav.setViewName("departments");
				return mav;
			}
		}
		
		
	}
	/**
	 * 修改部门
	 */
	@RequestMapping("/editdepartment.action")
	public ModelAndView modify(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		response.setCharacterEncoding("text/html;charset=utf-8");
		String id = request.getParameter("departmentid");
		String name = request.getParameter("departmentname");
		String remark  = request.getParameter("departmentremark");
		if(id == null || name == null || remark == null || "".equals(id)){
			mav.setViewName("departments");
			return mav;
		}
		Department department = new Department(id, name, remark);
		boolean isUpdated = dservice.update(department);
		String message;
		if(isUpdated){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		request.setAttribute("message", message);
		mav.setViewName("departments");
		return mav;
	}
	/**
	 * 删除部门
	 */
	@RequestMapping("/editdepartment.action")
	public ModelAndView editor (HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("departmentid");
		if(null == id || "".equals(id)){
			request.setAttribute("message", "id为空！");
			mav.setViewName("departments");
			return mav;
		}
		boolean isDeleted = dservice.delete(id);
		if(isDeleted){
			request.setAttribute("message", "删除成功！");
		}else{
			request.setAttribute("message", "删除失败！");
		}
		mav.setViewName("departments");
		return mav;
	}
}
