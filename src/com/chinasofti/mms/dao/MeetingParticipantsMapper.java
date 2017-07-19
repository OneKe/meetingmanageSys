package com.chinasofti.mms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

@Repository
public interface MeetingParticipantsMapper {
    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    int deleteByPrimaryKey(Integer mpid);

    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    int insert(MeetingParticipants record);

    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    int insertSelective(MeetingParticipants record);

    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    MeetingParticipants selectByPrimaryKey(Integer mpid);

    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    int updateByPrimaryKeySelective(MeetingParticipants record);

    /**
     * @mbggenerated Mon Jul 17 14:35:17 CST 2017
     */
    int updateByPrimaryKey(MeetingParticipants record);

	List<Meeting> selectByEmployeeName(Integer id);

	Employee findlogin(Employee employee);

	List<MeetingParticipants> selectMeetingByOrder(String id);

	Meeting selectMeetingByMeetingId(String meetingid);

	List<Meeting> selectCancelMeeting();
}