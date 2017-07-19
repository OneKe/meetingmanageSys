package com.chinasofti.mms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.pojo.MeetingRoom;

@Service
public class MeetingService {
	@Autowired
    private MeetingMapper dao;

	public MeetingMapper getDao() {
		return dao;
	}

	public void setDao(MeetingMapper dao) {
		this.dao = dao;
	}
    
	public List<MeetingParticipants> selectMeetingParticipantsByparticipantId(String id) {
		
		return dao.selectListsById(id);
	}

	public Meeting findMeetingByMeetingId(String meetingid) {
		
		return dao.findMeetingByMeetingId(meetingid);
	}

	public Employee selectEmployeeByUsername(String reservationistid) {
		
		return dao.selectEmployeeByUsername(reservationistid);
	}

	public List<Meeting> selectMeet(){
		return dao.selectMeeting();
	}
	
}
