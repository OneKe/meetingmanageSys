package com.chinasofti.mms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mms.pojo.Department;
import com.chinasofti.mms.pojo.Employee;
import com.chinasofti.mms.pojo.Meeting;
import com.chinasofti.mms.pojo.MeetingParticipants;
import com.chinasofti.mms.pojo.MeetingRoom;
import com.chinasofti.mms.service.EmployeeService;
import com.chinasofti.mms.service.MeetingRoomService;
import com.chinasofti.mms.service.MeetingService;
import com.chinasofti.mms.util.TransferUtil;

@Controller
public class MeetingController {
	@Autowired
	private MeetingService mservice;

	@Autowired
	private MeetingRoomService service;

	@Autowired
	private EmployeeService eservice;

	public MeetingService getMservice() {
		return mservice;
	}

	public void setMservice(MeetingService mservice) {
		this.mservice = mservice;
	}

	TransferUtil tfu = new TransferUtil();

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

	// 搜索会议
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
		// 获得输出流
		PrintWriter out = response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(jsonArray.toJSONString());
		out.close();
	}

	// 查看会议详情
	@RequestMapping("/querymeetingdetails.action")
	public String meetdetail(String meetingid, Model model) throws ParseException {
		if (null != meetingid) {
			Meeting meeting = mservice.findMeetingByMeetingId(meetingid);
			if (null != meeting) {
				String begintime = tfu.formatDate(meeting.getBegintime());
				String endtime = tfu.formatDate(meeting.getEndtime());
				model.addAttribute("begintime", begintime);
				model.addAttribute("endtime", endtime);
				model.addAttribute("meeting", meeting);
			}
			List<Employee> list = mservice.selectemployeeBymeetingid(meetingid);
			if (list.size() > 0) {
				model.addAttribute("list", list);
			}
		}
		return "meetingdetails";
	}

	// 查看所有未使用的会议室
	@RequestMapping("/queryunusedmeetroom.action")
	public String queryunusedmr(Model model) {
		List<MeetingRoom> roomlist = service.selectunusedmeetroom();
		if (roomlist.size() > 0) {
			model.addAttribute("mrlist", roomlist);
		}
		List<Department> departlist = service.selectAll();
		if (departlist.size() > 0) {
			model.addAttribute("dplist", departlist);
		}
		return "bookmeeting";
	}

	// 根据departmentid查询员工
	@RequestMapping("/queryemplbydpid.action")
	public void queryemplbydpid(String departmentid, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		System.out.println(departmentid);
		if (null != departmentid) {
			List<Employee> list = eservice.selectEmpByDpId(departmentid);
			if (list.size() > 0) {
				jsonObject.put("elist", list);
				jsonArray.add(jsonObject);
			} else {
				jsonObject.put("message", "出错了！");
				jsonArray.add(jsonObject);
			}
		} else {
			jsonObject.put("message", "出错了！");
			jsonArray.add(jsonObject);
		}
		// 获得输出流
		PrintWriter out = response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(jsonArray.toJSONString());
		out.close();
	}

	@RequestMapping("/bookingmeeting.action")
	public void bookmeet(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, JSONException, ParseException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String meetingname = request.getParameter("meetingname");
		String numofparticipants = request.getParameter("numofparticipants");
		String roomid = request.getParameter("roomid");
		String startdatetime = request.getParameter("startdatetime");
		String enddatetime = request.getParameter("enddatetime");
		String description = request.getParameter("description");
		String employeeids = request.getParameter("employeeids");
		HttpSession session = request.getSession();
		String reservationistid = (String) session.getAttribute("loginEmployeeId");
		String meetingid = tfu.getUUID();
		int numofptps = 0;
		if (null != numofparticipants) {
			numofptps = Integer.valueOf(numofparticipants).intValue();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date begintime = null;
		Date endtime = null;
		if (null != startdatetime && null != enddatetime) {
			begintime = sdf.parse(startdatetime);
			endtime = sdf.parse(enddatetime);
		}
		if (null != meetingid && !"".equals(meetingid) && null != meetingname && !"".equals(meetingname)
				&& null != roomid && !"".equals(roomid) && null != begintime && !"".equals(begintime) && null != endtime
				&& !"".equals(endtime) && numofptps > 0 && null != description && !"".equals(description)
				&& null != reservationistid && !"".equals(reservationistid)) {
			Meeting meeting = new Meeting(meetingid, meetingname, roomid, reservationistid, numofptps, begintime,
					endtime, new Date(), 1, description);
			System.out.println(meeting);
			int i=mservice.insert(meeting);
			System.out.println(i);
			if(i>0){
				System.out.println(service.updateroomstatusbyid(roomid));
			}
		}
		JSONArray jsonArray = JSONArray.parseArray(employeeids);
		JSONObject jsonObject;
		List<MeetingParticipants> list=new ArrayList<>();
		MeetingParticipants meetingParticipants=null;
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			meetingParticipants=new MeetingParticipants(tfu.getUUID(), meetingid, jsonObject.getString("employeeid"));
			list.add(meetingParticipants);
		}
		if(list.size()>0){
			System.out.println(mservice.insertMpt(list));
		}
	}
}
