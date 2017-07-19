package com.chinasofti.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
@Service
public class RoleService {
	@Autowired
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
		
		System.out.println(employee);
		
		Employee em = dao.findlogin(employee);
		
		return em;
	}

	public List<MeetingParticipants> selectMeetingParticipantsByparticipantId(String id) {
		
		return dao.selectMeetingByOrder(id);
	}

	public Meeting comingMeeting(String meetingid) {

		return dao.selectMeetingByMeetingId(meetingid);
	}

	public List<Meeting> cancelMeeting() {

		return dao.selectCancelMeeting();
	}
   
}
