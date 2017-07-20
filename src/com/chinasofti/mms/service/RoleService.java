package com.chinasofti.mms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
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
	
	/**
	 * 根据用户名查看我的预定会议信息
	 */
	public List<Meeting> selectByEmployeeName(String id) {
		List<Meeting> books = dao.selectByEmployeeName(id);
		return books;
	}
	
	/**
	 * 用户登录
	 */
	public Employee login(Employee employee) {
		
		System.out.println(employee);
		
		Employee em = dao.findlogin(employee);
		
		return em;
	}

	/**
	 * 在最新通知里显示：未来7天我要参加的会议
	 */
	public List<Map<String,Object>> selectMeetingParticipantsByparticipantId(String id) {
		
		return dao.selectMeetingByOrder(id);
	}
	
	/**
	 * 在最新通知里显示：已取消的会议
	 */
	public List<Map<String, Object>> cancelMeetingMap() {

		return dao.cancelMeetingMap();
	}
	/**
	 * 修改密码
	 * @param loginUserName
	 * @param originpassword
	 * @param newpassword
	 * @return
	 */
	public boolean updateNewPassword(String loginUserName, String originpassword, String newpassword) {

		return dao.updateNewPassword(loginUserName,originpassword,newpassword);
	}
	/**
	 * 通过会议id，查询会议详情
	 * @param meetingId
	 * @return
	 */
	public Meeting selectByMyMeetingById(String meetingId) {
		
		return dao.selectByMyMeetingById(meetingId);
	}

	/**
	 * 通过会议id，查询参加该会议的所有员工
	 * @param meetingId
	 * @return
	 */
	public List<Employee> selectEmployeeByMeetingId(String meetingId) {

		return dao.selectEmployeeByMeetingId(meetingId);
	}
   
}
