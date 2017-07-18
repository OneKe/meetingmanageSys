package com.chinasofti.mms.service;

import java.util.List;

import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;

public class RoleService {
	private MeetingParticipantsMapper dao;
	
	public MeetingParticipantsMapper getDao() {
		return dao;
	}

	public void setDao(MeetingParticipantsMapper dao) {
		this.dao = dao;
	}
	
	/*
	 * 根据用户名查看我的预定会议信息
	 */
	public List<Meeting> selectByEmployeeName(Integer id) {
		List<Meeting> books = dao.selectByEmployeeName(id);
		return books;
	}
	
	/*
	 * 用户登录
	 */
	public Employee login(Employee employee) {
		
		
		return dao.login(employee);
	}
   
}
