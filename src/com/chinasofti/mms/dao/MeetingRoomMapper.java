package com.chinasofti.mms.dao;

import com.chinasofti.mms.pojo.MeetingRoom;

public interface MeetingRoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    int deleteByPrimaryKey(Integer roomid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    int insert(MeetingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    int insertSelective(MeetingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    MeetingRoom selectByPrimaryKey(Integer roomid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    int updateByPrimaryKeySelective(MeetingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meetingroom
     *
     * @mbggenerated Mon Jul 17 14:36:31 CST 2017
     */
    int updateByPrimaryKey(MeetingRoom record);
}