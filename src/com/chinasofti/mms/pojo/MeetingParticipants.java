package com.chinasofti.mms.pojo;

public class MeetingParticipants {
   
    private String mpid;

    private String meetingid;

    private String participantid;

	public String getMpid() {
		return mpid;
	}

	public void setMpid(String mpid) {
		this.mpid = mpid;
	}

	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public String getParticipantid() {
		return participantid;
	}

	public void setParticipantid(String participantid) {
		this.participantid = participantid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meetingid == null) ? 0 : meetingid.hashCode());
		result = prime * result + ((mpid == null) ? 0 : mpid.hashCode());
		result = prime * result + ((participantid == null) ? 0 : participantid.hashCode());
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
		MeetingParticipants other = (MeetingParticipants) obj;
		if (meetingid == null) {
			if (other.meetingid != null)
				return false;
		} else if (!meetingid.equals(other.meetingid))
			return false;
		if (mpid == null) {
			if (other.mpid != null)
				return false;
		} else if (!mpid.equals(other.mpid))
			return false;
		if (participantid == null) {
			if (other.participantid != null)
				return false;
		} else if (!participantid.equals(other.participantid))
			return false;
		return true;
	}

	public MeetingParticipants() {
	}
	
	public MeetingParticipants(String mpid, String meetingid, String participantid) {
		this.mpid = mpid;
		this.meetingid = meetingid;
		this.participantid = participantid;
	}

	@Override
	public String toString() {
		return "MeetingParticipants [mpid=" + mpid + ", meetingid=" + meetingid + ", participantid=" + participantid
				+ "]";
	}

    
    
}