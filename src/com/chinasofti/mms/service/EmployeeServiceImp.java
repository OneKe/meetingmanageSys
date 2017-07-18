package com.chinasofti.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.EmployeeMapper;
import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.Employee;

/**
*@autor:yl email:1940927916@qq.com
*@version:1.8
*@Date:2017年7月18日 上午10:24:37
*@ps
*/
@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeMapper dao;

	public EmployeeMapper getDao() {
		return dao;
	}

	public void setDao(EmployeeMapper dao) {
		this.dao = dao;
	}

	@Override
	public int selectEmployeeByUsername(String username) {
		return dao.selectEmployeeByUsername(username);
	}

	@Override
	public List<Department> selectAllDepart() {
		return dao.selectAllDepart();
	}

	@Override
	public int insert(Employee record) {
		return dao.insert(record);
	}

	@Override
	public int approve(String employeeid) {
		return dao.approve(employeeid);
	}
	
	//查询待审批员工
	@Override
	public List<Employee> selectEmpByStatus() {
		return dao.selectEmpByStatus();
	}

}
