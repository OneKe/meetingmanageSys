package com.chinasofti.mms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingParticipantsMapper;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingRoom;
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
	 * 登陆后，根据用户的用户id查询我的预定
	 */

	public List<Map<String, Object>> selectByEmployeeName(String id) {

		return dao.selectByEmployeeName(id);
	}
	
	/**
	 * 用户登录
	 */
	public Employee login(Employee employee) {
		
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

	/**
	 * --------人员管理： 搜索员工
	 * @param paramMap
	 * @return
	 */
	public List<Employee> findEmployee(Map<String, Object> paramMap) {

		return dao.findEmployee(paramMap);
	}
	
	/**
	 * --------人员管理： 搜索员工-----关闭账号
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateEmployeeStatus(String id, int status) {
		
		return dao.updateEmployeeStatus(id,status);
	}

	/**
	 * ------个人中心 > 最新通知 > 撤销会议
	 * @param mtid
	 * @param canceledreson 
	 * @return
	 */
	public int cancelOneMeeting(String mtid, String canceledreson) {

		return dao.cancelOneMeeting(mtid,canceledreson);
	}

	/**
	 * -----会议预定 > 查看所有会议室
	 * @return
	 */
	public List<Map<String, Object>> selectMeetingRoomAll() {

		return dao.selectAllMeetingRoom();
	}

	/**
	 * -----会议预定 > 查看所有会议室 > 会议室详情
	 * @param id
	 * @return
	 */
	public MeetingRoom selectOneMeetingRoom(String id) {

		return dao.selectOneMeetingRoom(id);
	}

	/**
	 * -----会议预定 > 查看所有会议室 > 会议室详情 > 确认修改会议室信息
	 * @param mr
	 * @return
	 */
	public int updateMeetingRoom(MeetingRoom mr) {

		return dao.updateMeetingRoom(mr);
	}

   
}
