package com.chinasofti.mms.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
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
    
	public List<Meeting> cancelMeeting() {
		return dao.cancelMeeting();
	}
	
	public Meeting comingMeeting(int id) {
		return dao.comingMeeting(id);
	}

	public boolean alterMeeting(Meeting meeting) {
		return dao.alterMeeting(meeting);
	}

	public boolean alterMeetingStatus(int meetingid,String de) {
		return dao.alterMeetingStatus(meetingid,de);
	}

	public List<Meeting> selectAllMeeting() {
		return dao.selectAllMeeting();
	}

	public Meeting selectMeeting(int meetingid) {
		return dao.selectMeeting(meetingid);
	}

	public List<Meeting> selectByReservationistID(int reservationistID) {
		return dao.selectByReservationistID(reservationistID);
	}

	public Meeting selectByMeetingId(int meetingId) {
		return dao.selectByMeetingId(meetingId);
	}


	
}
