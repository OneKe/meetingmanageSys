package com.chinasofti.mms.dao;

import com.chinasofti.mms.pojo.Meeting;

public interface MeetingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    int deleteByPrimaryKey(Integer meetingid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    int insert(Meeting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    int insertSelective(Meeting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    Meeting selectByPrimaryKey(Integer meetingid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    int updateByPrimaryKeySelective(Meeting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meeting
     *
     * @mbg.generated Mon Jul 17 14:43:46 CST 2017
     */
    int updateByPrimaryKey(Meeting record);
}