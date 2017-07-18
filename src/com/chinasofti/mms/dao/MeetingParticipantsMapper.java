package com.chinasofti.mms.dao;

import java.util.List;

import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

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

	List<Meeting> selectByEmployeeName(String username);
}