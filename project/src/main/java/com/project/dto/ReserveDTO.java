package com.project.dto;

import java.util.Date;

public class ReserveDTO {
	private int rnum;
	private String roomid;
	private String startdate;
	private String enddate;
	private String userid;
	private Date regdate;
	
	public ReserveDTO() {
		super();
	}

	public ReserveDTO(int rnum, String roomid, String startdate, String enddate, String userid,
			Date regdate) {
		super();
		this.rnum = rnum;
		this.roomid = roomid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.userid = userid;
		this.regdate = regdate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReserveDTO [rnum=" + rnum + ", roomid=" + roomid + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", userid=" + userid + ", regdate=" + regdate + "]";
	}
	
	
	

	
	
	
	

}
