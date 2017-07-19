package com.chinasofti.mms.dao;

import com.chinasofti.mms.pojo.MeetingRoom;

public interface MeetingRoomMapper {
    
    int deleteByPrimaryKey(Integer roomid);
    
    //添加会议室
    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);
}