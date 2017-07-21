package com.chinasofti.mms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

@Repository
public interface MeetingParticipantsMapper {
    
    int deleteByPrimaryKey(Integer mpid);

    int insert(MeetingParticipants record);

    int insertSelective(MeetingParticipants record);

    MeetingParticipants selectByPrimaryKey(Integer mpid);

    int updateByPrimaryKeySelective(MeetingParticipants record);

    int updateByPrimaryKey(MeetingParticipants record);

	List<Meeting> selectByEmployeeName(String id);

	Employee findlogin(Employee employee);
	
	/**
	 * 在最新通知里显示：未来7天我要参加的会议
	 */
	List<Map<String,Object>> selectMeetingByOrder(String id);

	/**
	 * 在最新通知里显示：已取消的会议
	 */
	List<Map<String, Object>> cancelMeetingMap();
	
	/**
	 * 修改密码
	 * @param loginUserName
	 * @param originpassword
	 * @param newpassword
	 * @return
	 */
	boolean updateNewPassword(String loginUserName, String originpassword, String newpassword);
	
	/**
	 * 通过会议id，查询会议详情
	 * @param meetingId
	 * @return
	 */
	Meeting selectByMyMeetingById(String meetingId);

	/**
	 *  通过会议id，查询参加该会议的所有员工
	 * @param meetingId
	 * @return
	 */
	List<Employee> selectEmployeeByMeetingId(String meetingId);

}