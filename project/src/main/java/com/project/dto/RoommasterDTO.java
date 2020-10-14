package com.project.dto;

import java.util.Date;

public class RoommasterDTO {
	
	private String roomid;
	private String roomname;
	private String content1;
	private String content2;
	private String content3;
	private Date regdate;
	
	public RoommasterDTO() {
		super();
	}

	public RoommasterDTO(String roomid, String roomname, String content1, String content2, String content3,
			Date regdate) {
		super();
		this.roomid = roomid;
		this.roomname = roomname;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.regdate = regdate;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "RoommasterDTO [roomid=" + roomid + ", roomname=" + roomname + ", content1=" + content1 + ", content2="
				+ content2 + ", content3=" + content3 + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	

}
