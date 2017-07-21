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

	
	public boolean addDepartment(String departmentName) {
		
		return dao.department(departmentName);
	}

	public String testDepartmentName(String departmentName) {
		return dao.testDepartmentName(departmentName);
	}

	public boolean update(Department department) {
		return dao.update(department);
	}

	public boolean delete(String id) {
		return dao.delete(id);
	}
	
	public List<Department> selectAll(){
		return dao.selectAll();
	}

}
