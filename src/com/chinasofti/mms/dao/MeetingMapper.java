package com.chinasofti.mms.dao;

import java.util.List;

import com.chinasofti.mms.pojo.Meeting;

public interface MeetingMapper {
    
    int deleteByPrimaryKey(Integer meetingid);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingid);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    
    List<Meeting> cancelMeeting();
    
    Meeting comingMeeting(int id);
    
    boolean alterMeeting(Meeting meeting);
    
    boolean alterMeetingStatus(int meetingid, String de);
    
    List<Meeting> selectAllMeeting();
    
    Meeting selectMeeting(int meetingid);
    
    List<Meeting> selectByReservationistID(int reservationistID);
    
    Meeting selectByMeetingId(int meetingId);
    
    boolean inserty(Meeting meeting);

    List<Meeting> selectByRoomIdStartEndTime(int roomId, java.util.Date date, java.util.Date date2);
    
    //搜索会议
    List<Meeting> selectMeeting();
    
    
    
    
    
    
     
}