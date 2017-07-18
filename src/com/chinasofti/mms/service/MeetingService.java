package com.chinasofti.mms.service;


import com.chinasofti.mms.dao.MeetingMapper;

public class MeetingService {
    private MeetingMapper dao;

	public MeetingMapper getDao() {
		return dao;
	}

	public void setDao(MeetingMapper dao) {
		this.dao = dao;
	}
    
	
}
