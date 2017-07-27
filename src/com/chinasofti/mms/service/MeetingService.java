package com.chinasofti.mms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingMapper;
import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

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
	
	@Autowired
	private MeetingParticipantsMapper mpt;
	
	public List<Map<String, Object>> selectMeetingParticipantsByparticipantId(String id) {

		return dao.selectListsById(id);
	}

	public Meeting findMeetingByMeetingId(String meetingid) {

		return dao.findMeetingByMeetingId(meetingid);
	}

	public Employee selectEmployeeByUsername(String reservationistid) {

		return dao.selectEmployeeByUsername(reservationistid);
	}

	public List<Map<String, Object>> selectMeet(Map<Object, Object> map) {
		return dao.selectMeet(map);
	}
	
	public List<Employee> selectemployeeBymeetingid(String meetingid){
		return dao.selectemployeeBymeetingid(meetingid);
	}
	
	//预约会议
	public int insert(Meeting record){
		return dao.insert(record);
	}
	
	//批量添加
	public int insertMpt(List<MeetingParticipants> list){
		return mpt.insertMpt(list);
	}
	
	//会议总数
	public int meetingcount(Map<Object, Object> map){
		return dao.meetingcount(map);
	}
}
