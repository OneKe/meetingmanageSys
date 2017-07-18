package com.chinasofti.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeetingController {
	 @RequestMapping("/mymeeting.action")
     public ModelAndView MyMeeting(HttpServletRequest request,HttpServletResponse response){
    	HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("mymeeting.jsp");
        System.out.println("MeetingController -->");
    	 
    	 return mav;
     }
}
