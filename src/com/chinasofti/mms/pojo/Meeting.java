package com.chinasofti.mms.pojo;

import java.util.Date;
import java.util.List;

public class Meeting {
    
    private String meetingid;

    private String meetingname;

    private String roomid;

    private String reservationistid;

    private Integer numofparticipants;

    private Date begintime;

    private Date endtime;

    private Date reservationtime;

    private Date canceledtime;

    private String meetingstatus;

    private String description;
    
    private MeetingRoom MeetingRoom;
    
    private List<Employee> Employee;

	public MeetingRoom getMeetingRoom() {
		return MeetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		MeetingRoom = meetingRoom;
	}

	public List<Employee> getEmployee() {
		return Employee;
	}

	public void setEmployee(List<Employee> employee) {
		Employee = employee;
	}

	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getReservationistid() {
		return reservationistid;
	}

	public void setReservationistid(String reservationistid) {
		this.reservationistid = reservationistid;
	}

	public Integer getNumofparticipants() {
		return numofparticipants;
	}

	public void setNumofparticipants(Integer numofparticipants) {
		this.numofparticipants = numofparticipants;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getReservationtime() {
		return reservationtime;
	}

	public void setReservationtime(Date reservationtime) {
		this.reservationtime = reservationtime;
	}

	public Date getCanceledtime() {
		return canceledtime;
	}

	public void setCanceledtime(Date canceledtime) {
		this.canceledtime = canceledtime;
	}

	public String getMeetingstatus() {
		return meetingstatus;
	}

	public void setMeetingstatus(String meetingstatus) {
		this.meetingstatus = meetingstatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Meeting() {
	}
	
	public Meeting(String meetingid, String meetingname, String roomid, String reservationistid,
			Integer numofparticipants, Date begintime, Date endtime, Date reservationtime, Date canceledtime,
			String meetingstatus, String description) {
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.roomid = roomid;
		this.reservationistid = reservationistid;
		this.numofparticipants = numofparticipants;
		this.begintime = begintime;
		this.endtime = endtime;
		this.reservationtime = reservationtime;
		this.canceledtime = canceledtime;
		this.meetingstatus = meetingstatus;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Meeting [meetingid=" + meetingid + ", meetingname=" + meetingname + ", roomid=" + roomid
				+ ", reservationistid=" + reservationistid + ", numofparticipants=" + numofparticipants + ", begintime="
				+ begintime + ", endtime=" + endtime + ", reservationtime=" + reservationtime + ", canceledtime="
				+ canceledtime + ", meetingstatus=" + meetingstatus + ", description=" + description + ", MeetingRoom="
				+ MeetingRoom + ", Employee=" + Employee + "]";
	}

}