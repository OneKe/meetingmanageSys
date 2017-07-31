package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.service.RoleService;

import com.chinasofti.mms.pojo.Page;

@Controller
public class FindAllEmployeesController {

	@Autowired
	private RoleService service;

	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}

	@RequestMapping("searchemployees.action")
	public ModelAndView findEmployees(Page page, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		ModelAndView mv = new ModelAndView("searchemployees");
		// 从页面拿值
		String employeeName = request.getParameter("employeename");
		String accountName = request.getParameter("accountname");
		String status = request.getParameter("status");
		// 将账号状态，每页展示页，开始位置 转换为int类型，作为参数
		int intStatus = Integer.parseInt(status);

		// 判断是否为空，设置默认值
		if (null == employeeName) {
			employeeName = "";
		}
		if (null == accountName) {
			accountName = "";
		}
		if (null == status) {
			status = "1";
		}
		Page p = page;
		int pageSize = 4; // 设置每页大小
		p.setPageSize(pageSize);
		int curPage = p.getCurrentPage();

		if (curPage == 0) {
			curPage = 1;
			p.setCurrentPage(curPage);
		}
		int startRow = page.getStartRow();

		if (!(p.getCurrentPage() == 0)) {
			startRow = getStartRowBycurrentPage(curPage, pageSize);
		}

		p.setStartRow(startRow);

		String queryCondition = null;
		if (page.getQueryCondition() != null) {
			queryCondition = page.getQueryCondition();// 查询条件
		}

		Integer totalCounts = service.searchTotalCount(employeeName,accountName,intStatus);// 总条数

		int totalPages = (totalCounts % pageSize == 0) ? (totalCounts / pageSize) : (totalCounts / pageSize + 1);// 总页数=总条数/页大小+1

		p.setTotalPage(totalPages);// 总页数

		page.setTotalRows(totalCounts);// 总行数

		// 将多个参数封装进map中
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employeeName",employeeName);
		paramMap.put("accountName",accountName);
		paramMap.put("intStatus",intStatus);
		paramMap.put("page",page);

		// 按条件去数据库查询符合条件的用户
		List<Employee> list = service.findEmployee(paramMap);

		// 将从数据库查询到的值，写进request中，页面取值
		request.setAttribute("list",list);
		request.setAttribute("page", page);
		for(Employee employee:list){
			System.out.println(employee);
		}

		return mv;
	}

	/**
	 * 根据当前页获取开始行
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */

	public int getStartRowBycurrentPage(int currentPage, int pageSize) {

		int startRow = 0;

		if (currentPage == 1) {

			return startRow = 0;
		}

		startRow = (currentPage - 1) * pageSize;

		return startRow;

	}

	@RequestMapping("closeemployee.action")
	public ModelAndView CloseAccount(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("searchemployees");
		String id = request.getParameter("id");
		if (null == id || "".equals(id)) {
			request.setAttribute("message", "id为空！");
			return mv;
		}
		int isClosed = service.updateEmployeeStatus(id, 2);
		if (isClosed > 0) {
			request.setAttribute("message", "关闭成功！");
			return mv;
		} else {
			request.setAttribute("message", "关闭失败！");
			return mv;
		}

	}

	@RequestMapping("findalluser.action")
	public void findUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String status = request.getParameter("status");
		int startS = Integer.parseInt(status);
		System.out.println("findalluser中的" + status);
		List<Employee> userlist = service.findUserList(startS);
		PrintWriter out = response.getWriter();
		out.println(userlist.size());
		out.close();
	}

}
