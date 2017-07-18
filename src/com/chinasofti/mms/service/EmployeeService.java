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
	
	int selectEmployeeByUsername(String username);
	
	List<Department> selectAllDepart();
	
	int insert(Employee record);
}
