package com.project.dto;

import java.util.Date;

public class RfileDTO {
	private int rnum;
	private String roomid;
	private String filename;
	private Date regdate;
	
	public RfileDTO() {
		super();
	}

	public RfileDTO(int rnum, String roomid, String filename, Date regdate) {
		super();
		this.rnum = rnum;
		this.roomid = roomid;
		this.filename = filename;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "RfileDTO [rnum=" + rnum + ", roomid=" + roomid + ", filename=" + filename + ", regdate=" + regdate
				+ "]";
	}
	
	

	
	
}
