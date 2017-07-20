package com.chinasofti.mms.dao;

import com.chinasofti.mms.pojo.Department;

public interface DepartmentMapper {
    
    int deleteByPrimaryKey(Integer departmentid);

    
    int insert(Department record);

    
    int insertSelective(Department record);

   
    Department selectByPrimaryKey(Integer departmentid);

   
    int updateByPrimaryKeySelective(Department record);

   
    int updateByPrimaryKey(Department record);


	boolean department(String departmentName);


	boolean delete(String id);


	boolean update(Department department);
    
    
    
}