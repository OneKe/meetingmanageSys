package com.chinasofti.mms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingRoomMapper;
@Service
public class FindMeetingService {
    @Autowired	
    private MeetingRoomMapper dao;

	public MeetingRoomMapper getDao() {
		return dao;
	}

	public void setDao(MeetingRoomMapper dao) {
		this.dao = dao;
	}

	
    



}
