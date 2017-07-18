package com.chinasofti.mms.pojo;

public class MeetingRoom {
    
    private Integer roomid;

    private String roomcode;

    private String roomname;

    private Integer roomcapacity;

    private Integer roomstatus;

    private String description;

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getRoomcapacity() {
		return roomcapacity;
	}

	public void setRoomcapacity(Integer roomcapacity) {
		this.roomcapacity = roomcapacity;
	}

	public Integer getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(Integer roomstatus) {
		this.roomstatus = roomstatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((roomcapacity == null) ? 0 : roomcapacity.hashCode());
		result = prime * result + ((roomcode == null) ? 0 : roomcode.hashCode());
		result = prime * result + ((roomid == null) ? 0 : roomid.hashCode());
		result = prime * result + ((roomname == null) ? 0 : roomname.hashCode());
		result = prime * result + ((roomstatus == null) ? 0 : roomstatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingRoom other = (MeetingRoom) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (roomcapacity == null) {
			if (other.roomcapacity != null)
				return false;
		} else if (!roomcapacity.equals(other.roomcapacity))
			return false;
		if (roomcode == null) {
			if (other.roomcode != null)
				return false;
		} else if (!roomcode.equals(other.roomcode))
			return false;
		if (roomid == null) {
			if (other.roomid != null)
				return false;
		} else if (!roomid.equals(other.roomid))
			return false;
		if (roomname == null) {
			if (other.roomname != null)
				return false;
		} else if (!roomname.equals(other.roomname))
			return false;
		if (roomstatus == null) {
			if (other.roomstatus != null)
				return false;
		} else if (!roomstatus.equals(other.roomstatus))
			return false;
		return true;
	}

	public MeetingRoom() {
	}
	
	public MeetingRoom(Integer roomid, String roomcode, String roomname, Integer roomcapacity, Integer roomstatus,
			String description) {
		this.roomid = roomid;
		this.roomcode = roomcode;
		this.roomname = roomname;
		this.roomcapacity = roomcapacity;
		this.roomstatus = roomstatus;
		this.description = description;
	}

	@Override
	public String toString() {
		return "MeetingRoom [roomid=" + roomid + ", roomcode=" + roomcode + ", roomname=" + roomname + ", roomcapacity="
				+ roomcapacity + ", roomstatus=" + roomstatus + ", description=" + description + "]";
	}

    
    
}