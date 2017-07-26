package com.chinasofti.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.mms.pojo.MeetingRoom;
import com.chinasofti.mms.service.MeetingRoomService;
import com.chinasofti.mms.util.TransferUtil;

@Controller
public class MeetingRoomController {
	
	@Autowired
	private MeetingRoomService service;
	
	TransferUtil tfu=new TransferUtil();
	
	@RequestMapping("/addmeetingroom.action")
	public String insertMeetingRoom(MeetingRoom meetingRoom, Model model) {
		if(null!=meetingRoom){
			meetingRoom.setRoomid(tfu.getUUID());
			int i=service.insert(meetingRoom);
			if(i>0){
				model.addAttribute("message", "注册成功！");
			}else{
				model.addAttribute("message", "注册失败！");
			}
		}
		return "addmeetingroom";
	}
}
