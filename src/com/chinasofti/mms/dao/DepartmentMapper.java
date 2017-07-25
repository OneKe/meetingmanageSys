package com.chinasofti.mms.dao;

import java.util.List;

import com.chinasofti.mms.pojo.Department;

public interface DepartmentMapper {
    
    int deleteByPrimaryKey(Integer departmentid);

    
    int insert(Department record);

    
    int insertSelective(Department record);

   
    Department selectByPrimaryKey(Integer departmentid);

   
    int updateByPrimaryKeySelective(Department record);

   
    int updateByPrimaryKey(Department record);


	int department(Department department);


	int delete(Integer id);


	int update(Department department);


	String testDepartmentName(String departmentName);


	List<Department> selectAll();
	
	//根据部门名查询部门
	int findDepartByName(String departmentname);
    
}