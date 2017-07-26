package com.chinasofti.mms.pojo;

import java.util.Date;

public class Meeting {

	private String meetingid;			//会议ID

	private String meetingname;			//会议名称

	private String roomid;				//会议室ID

	private String reservationistid;	//预订者ID

	private Integer numofparticipants;	//预计参加人数

	private Date begintime;				//预计开始时间

	private Date endtime;				//预计结束时间

	private Date reservationtime;		//预定时间

	private Date canceledtime;			//会议取消时间

	private Integer meetingstatus;		//会议状态，1表示正常，2表示取消

	private String description;			//会议描述
	
	private String CanceledReson;		//会议取消原因
	
	private Employee employee;			//员工对象
	
	private MeetingRoom meetingRoom;	//会议室对象

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public String getCanceledReson() {
		return CanceledReson;
	}

	public void setCanceledReson(String canceledReson) {
		CanceledReson = canceledReson;
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

	public Integer getMeetingstatus() {
		return meetingstatus;
	}

	public void setMeetingstatus(Integer meetingstatus) {
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
			Integer numofparticipants, Date begintime, Date endtime, Date reservationtime,
			Integer meetingstatus, String description) {
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.roomid = roomid;
		this.reservationistid = reservationistid;
		this.numofparticipants = numofparticipants;
		this.begintime = begintime;
		this.endtime = endtime;
		this.reservationtime = reservationtime;
		this.meetingstatus = meetingstatus;
		this.description = description;
	}
	
	public Meeting(String meetingid, String meetingname, String roomid, String reservationistid,
			Integer numofparticipants, Date begintime, Date endtime, Date reservationtime, Date canceledtime,
			Integer meetingstatus, String description) {
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
				+ canceledtime + ", meetingstatus=" + meetingstatus + ", description=" + description
				+ ", CanceledReson=" + CanceledReson + ", employee=" + employee + ", meetingRoom=" + meetingRoom + "]";
	}

}