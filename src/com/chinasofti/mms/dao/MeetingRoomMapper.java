package com.chinasofti.mms.dao;

import java.util.List;

import com.chinasofti.mms.pojo.MeetingRoom;

public interface MeetingRoomMapper {
    
    int deleteByPrimaryKey(String roomid);
    
    //添加会议室
    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);
    
    //查看未使用的会议室
    List<MeetingRoom> selectunusedmeetroom();
    
    //修改会议室状态
    int updateroomstatusbyid(String roomid);
}