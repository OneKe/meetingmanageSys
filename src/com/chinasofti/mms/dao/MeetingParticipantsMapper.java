package com.chinasofti.mms.dao;

import java.util.List;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

public interface MeetingParticipantsMapper {
    
    int deleteByPrimaryKey(Integer mpid);

    int insert(MeetingParticipants record);

    int insertSelective(MeetingParticipants record);

    MeetingParticipants selectByPrimaryKey(Integer mpid);

    int updateByPrimaryKeySelective(MeetingParticipants record);

    int updateByPrimaryKey(MeetingParticipants record);

	List<Meeting> selectByEmployeeName(Integer id);

	Employee login(Employee employee);
}