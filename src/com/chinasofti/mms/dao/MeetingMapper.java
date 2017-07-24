package com.chinasofti.mms.dao;

import java.util.List;
import java.util.Map;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;

public interface MeetingMapper {
    
    int deleteByPrimaryKey(Integer meetingid);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingid);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    
 
   	List<Meeting> selectByEmployeeName(Integer id);
   	
    //根据list<Meeting>查处每个会议的预定者id
	Meeting findUserIdByMeetingId(String id);
	
	
	Employee selectEmployeeByUsername(String id);
    
    /*
     * 通过参加会议的员工的id查找员工与会议关系的对象
     */
	List<MeetingParticipants> selectListsById(String id);
	
	/*
	 * 通过员工与会议关系的对象拿到会议id，通过会议id查询该会议
	 */
	Meeting findMeetingByMeetingId(String meetingid);
    
    //搜索会议
    List<Map<String, Object>> selectMeet(Map<Object, Object> map);
    
    
    List<Employee> selectemployeeBymeetingid(String meetingid);
    
    
    
    
     
}