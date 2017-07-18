package com.chinasofti.mms.service;

import java.util.List;

import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Meeting;

public class RoleService {
	private MeetingParticipantsMapper dao;
	
	public MeetingParticipantsMapper getDao() {
		return dao;
	}

	public void setDao(MeetingParticipantsMapper dao) {
		this.dao = dao;
	}

	public List<Meeting> selectByEmployeeName(String username) {
		List<Meeting> books = dao.selectByEmployeeName(username);
		return books;
	}
   
}
