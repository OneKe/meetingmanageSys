package com.chinasofti.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.DepartmentMapper;
import com.chinasofti.mms.pojo.Department;

@Service
public class DepartmentService {
    @Autowired
	private DepartmentMapper dao;
    
	public DepartmentMapper getDao() {
		return dao;
	}

	public void setDao(DepartmentMapper dao) {
		this.dao = dao;
	}

	
	public int addDepartment(Department department) {
		return dao.department(department);
	}

	public String testDepartmentName(String departmentName) {
		return dao.testDepartmentName(departmentName);
	}
	
	//修改部门
	public int update(Department department) {
		return dao.update(department);
	}

	public int delete(Integer id) {
		return dao.delete(id);
	}
	
	public List<Department> selectAll(){
		return dao.selectAll();
	}
	
	//根据部门名查询部门
	public int findDepartByName(String departmentname){
		return dao.findDepartByName(departmentname);
	}

}
