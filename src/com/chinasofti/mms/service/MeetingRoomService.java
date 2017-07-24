package com.chinasofti.mms.service;

import java.util.List;

import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.MeetingRoom;

public interface MeetingRoomService {

	// 添加会议室
	int insert(MeetingRoom record);

	// 查询未使用的会议室
	List<MeetingRoom> selectunusedmeetroom();

	// 查询所有部门
	List<Department> selectAll();

	// 修改会议室状态
	int updateroomstatusbyid(String roomid);
}
