package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.service.MeetingService;

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
    	Employee employee;
    	if (lists!=null) {
			for (MeetingParticipants mps : lists) {
				Meeting meet = mservice.findMeetingByMeetingId(mps.getMeetingid());
				if (meet!=null) {
					mList.add(meet);
				}
			}
		}
    	for (Meeting meeting : mList) {
    		employee= mservice.selectEmployeeByUsername(meeting.getReservationistid());
    		if(employee!=null){
    			namelist.add(employee.getUsername());
    		}
		}
        ModelAndView mav = new ModelAndView("mymeeting.jsp");
    	mav.addObject("meetings", mList);
    	mav.addObject("namelist",namelist);
    	return mav;
     }
	
	
	@RequestMapping("/meetingdetails.action")
	public ModelAndView MeetingDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		String meetingId = request.getParameter("meetingid");
		if (null == meetingId || "".equals(meetingId)) {
			meetingId = "0";
		}
		
		
		
		return null;
		
	}
	
	@RequestMapping("/jsp/searchmeeting.action")
	public String selectMeeting(Model model){
		List<Meeting> list=mservice.selectMeet();
		for (Meeting meeting : list) {
			System.out.println(meeting);
		}
		model.addAttribute("list", list);
		return "searchmeetings";
	}
}
