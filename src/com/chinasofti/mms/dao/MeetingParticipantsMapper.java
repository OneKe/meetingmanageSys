package com.chinasofti.mms.dao;

import java.util.List;

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

	List<MeetingParticipants> selectMeetingByOrder(String id);

	Meeting selectMeetingByMeetingId(String meetingid);

	List<Meeting> selectCancelMeeting();

	String selectRoomNameByid(String roomid);

}