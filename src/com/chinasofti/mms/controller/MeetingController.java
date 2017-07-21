package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.service.MeetingService;
import com.chinasofti.mms.util.TransferUtil;

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
	
	TransferUtil tfu=new TransferUtil();

	@RequestMapping("/mymeeting.action")
	public ModelAndView MyMeeting(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginEmployeeId");
		List<MeetingParticipants> lists = mservice.selectMeetingParticipantsByparticipantId(id);
		List<Meeting> mList = new ArrayList<Meeting>();
		List<String> namelist = new ArrayList<String>();
		Employee employee;
		if (lists != null) {
			for (MeetingParticipants mps : lists) {
				Meeting meet = mservice.findMeetingByMeetingId(mps.getMeetingid());
				if (meet != null) {
					mList.add(meet);
				}
			}
		}
		for (Meeting meeting : mList) {
			employee = mservice.selectEmployeeByUsername(meeting.getReservationistid());
			if (employee != null) {
				namelist.add(employee.getUsername());
			}
		}
		ModelAndView mav = new ModelAndView("mymeeting.jsp");
		mav.addObject("meetings", mList);
		mav.addObject("namelist", namelist);
		return mav;
	}

	@RequestMapping("/searchmeeting.action")
	public void selectMeeting(String meetingname, String roomname, String reservername, String reservefromdate,
			String reservetodate, String meetingfromdate, String meetingtodate, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<Object, Object> map = new HashMap<>();
		map.put("meetingname", meetingname);
		map.put("roomname", roomname);
		map.put("reservername", reservername);
		map.put("reservefromdate", reservefromdate);
		map.put("reservetodate", reservetodate);
		map.put("meetingfromdate", meetingfromdate);
		map.put("meetingtodate", meetingtodate);
		List<Map<String, Object>> list = mservice.selectMeet(map);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("list", list);
		jsonArray.add(jsonObject);
		System.out.println(jsonArray);
		// 获得输出流
		PrintWriter out = response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(jsonArray.toJSONString());
		out.close();
	}

	@RequestMapping("/querymeetingdetails.action")
	public String meetdetail(String meetingid, Model model) throws ParseException {
		if (null != meetingid) {
			Meeting meeting = mservice.findMeetingByMeetingId(meetingid);
			if(null!=meeting){
				String begintime=tfu.formatDate(meeting.getBegintime());
				String endtime=tfu.formatDate(meeting.getEndtime());
				model.addAttribute("begintime", begintime);
				model.addAttribute("endtime", endtime);
				model.addAttribute("meeting", meeting);
			}
			List<Employee> list = mservice.selectemployeeBymeetingid(meetingid);
			if(list.size()>0){
				model.addAttribute("list", list);
			}
		}
		return "meetingdetails";
	}
}
