package com.chinasofti.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.DepartmentMapper;
import com.chinasofti.mms.dao.MeetingRoomMapper;
import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.MeetingRoom;

@Service
public class MeetingRoomServiceImp implements MeetingRoomService {
	
	@Autowired
	private MeetingRoomMapper dao;
	
	@Autowired
	private DepartmentMapper ddao;
	
	@Override
	public int insert(MeetingRoom record) {
		return dao.insert(record);
	}

	@Override
	public List<MeetingRoom> selectunusedmeetroom() {
		return dao.selectunusedmeetroom();
	}

	@Override
	public List<Department> selectAll() {
		return ddao.selectAll();
	}

}
