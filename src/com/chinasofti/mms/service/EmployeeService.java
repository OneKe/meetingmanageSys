package com.chinasofti.mms.service;

import java.util.List;

import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.Employee;

/**
*@autor:yl email:1940927916@qq.com
*@version:1.8
*@Date:2017年7月18日 上午10:22:47
*@ps
*/
public interface EmployeeService {
	
	//根据账户名查询员工
	int selectEmployeeByUsername(String username);
	
	//查询部门
	List<Department> selectAllDepart();
	
	//注册员工
	int insert(Employee record);
	
	//员工审核
	int approve(String employeeid);
	
	//查询待审批员工
	List<Employee> selectEmpByStatus();
}
