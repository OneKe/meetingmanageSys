package com.chinasofti.mms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.service.MeetingService;

import sun.print.resources.serviceui;

@Controller
public class MeetingController {
	@Autowired
	private MeetingService mservice;
	
	 public MeetingService getMservice() {
		return mservice;
	}

	public void setMservice(MeetingService mservice) {
		this.mservice = mservice;
	}

	@RequestMapping("/mymeeting.action")
     public ModelAndView MyMeeting(HttpServletRequest request,HttpServletResponse response){
    	HttpSession session = request.getSession();
    	String id = (String) session.getAttribute("loginEmployeeId");
    	List<MeetingParticipants> lists = mservice.selectMeetingParticipantsByparticipantId(id);
    	List<Meeting> mList =new ArrayList<Meeting>();
    	List<String> namelist= new ArrayList<String>();
    	String name=null;
    	if (lists!=null) {
			for (MeetingParticipants mps : lists) {
				Meeting meet = mservice.findMeetingByMeetingId(mps.getMeetingid());
				if (meet!=null) {
					mList.add(meet);
				}
			}
		}
    	for (Meeting meeting : mList) {
    		name= mservice.findUserIdByMeetingId(meeting.getReservationistid());
    		if(name!=null){
    			namelist.add(name);
    		}
		}
        ModelAndView mav = new ModelAndView("mymeeting.jsp");
    	mav.addObject("meetings", mList);
    	mav.addObject("namelist",namelist);
    	return mav;
     }
	
	
	@RequestMapping("/")
	public ModelAndView MeetingDetail(HttpServletRequest request,HttpServletResponse response){
		
		
		
		return null;
		
	}
}
