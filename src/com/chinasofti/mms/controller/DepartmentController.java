package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.service.DepartmentService;
import com.chinasofti.mms.util.TransferUtil;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService dservice;
	TransferUtil tfu = new TransferUtil();

	public DepartmentService getDservice() {
		return dservice;
	}

	public void setDservice(DepartmentService dservice) {
		this.dservice = dservice;
	}

	// 查询所有部门
	@RequestMapping("/queryAllDepartment.action")
	public void selectAllDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Department> list = dservice.selectAll();
		for (Department department : list) {
			if (null == department.getRemark()) {
				department.setRemark("");
			}
		}
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list.size() > 0) {
			jsonObject.put("list", list);
			jsonArray.add(jsonObject);
			// 获得输出流
			PrintWriter out = response.getWriter();
			// 通过 out 对象将 jsonArray 传到前端页面
			out.println(jsonArray);
			out.close();
		}
	}

	/**
	 * 添加部门
	 * @throws IOException 
	 */
	@RequestMapping("/adddepartmen.action")
	public String ManageDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String departmentname=request.getParameter("departmentName");
		Department department=new Department(departmentname);
		int i=0;
		if(department!=null){
			i=dservice.addDepartment(department);
			if(i>0){
				return "departments";
			}
		}
		return null;
	}

	/**
	 * 修改部门
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/editdepartment.action")
	public void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer departmentid = Integer.valueOf(request.getParameter("departmentid")).intValue();
		String departmentname = request.getParameter("departmentname");
		String remark = request.getParameter("remark");
		int i = 0;
		if (null != departmentid && !"".equals(departmentid) && null != departmentname && !"".equals(departmentname)
				&& null != remark && !"".equals(remark)) {
			Department department = new Department(departmentid, departmentname, remark);
			i = dservice.update(department);
		}
		PrintWriter out = response.getWriter();
		out.println(i);
		out.close();
	}

	/**
	 * 删除部门
	 */
	@RequestMapping("/deletedepartment.action")
	public void editor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer departmentid = Integer.valueOf(request.getParameter("departmentid")).intValue();
		int i = 0;
		if (departmentid > 0) {
			i = dservice.delete(departmentid);
		}
		PrintWriter out = response.getWriter();
		out.println(i);
		out.close();
	}
	
	/**
	 * 根据部门名查询部门
	 * @throws IOException 
	 */
	
	@RequestMapping("/querydepartbyname.action")
	public void findDepartByName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String departmentname=request.getParameter("departmentname");
		int i=0;
		if(null!=departmentname&&!"".equals(departmentname)){
			i=dservice.findDepartByName(departmentname);
			System.out.println(i);
		}
		PrintWriter out = response.getWriter();
		out.println(i);
		out.close();
	}
}
