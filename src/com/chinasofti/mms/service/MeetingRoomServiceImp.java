package com.chinasofti.mms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingRoomMapper;
import com.chinasofti.mms.pojo.MeetingRoom;

@Service
public class MeetingRoomServiceImp implements MeetingRoomService {
	
	@Autowired
	private MeetingRoomMapper dao;
	
	@Override
	public int insert(MeetingRoom record) {
		return dao.insert(record);
	}

}
