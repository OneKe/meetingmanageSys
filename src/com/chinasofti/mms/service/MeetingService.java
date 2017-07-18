package com.chinasofti.mms.service;

import org.springframework.stereotype.Service;

import com.chinasofti.mms.dao.MeetingMapper;

@Service
public class MeetingService {
    private MeetingMapper dao;

	public MeetingMapper getDao() {
		return dao;
	}

	public void setDao(MeetingMapper dao) {
		this.dao = dao;
	}
    
	
}
