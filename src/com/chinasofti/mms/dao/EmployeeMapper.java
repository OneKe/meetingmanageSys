package com.chinasofti.mms.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.Employee;

@Component
public interface EmployeeMapper {

	int deleteByPrimaryKey(String employeeid);

	// 员工注册
	int insert(Employee record);

	int insertSelective(Employee record);

	Employee selectByPrimaryKey(String employeeid);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);

	// 验证账户名是否合适
	int selectEmployeeByUsername(String username);

	// 查询部门
	List<Department> selectAllDepart();

	// 员工审核
	int approve(Employee employee);
	
	//查询待审批员工
	List<Employee> selectEmpByStatus();
}