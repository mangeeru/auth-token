package com.tech.auth.token.jmt.dto;

public class JmToken {
	
	private String userid;
	private String start;
	private String end;
	
	public JmToken() {
		// TODO Auto-generated constructor stub
	}

	public JmToken(String userid, String start, String end) {
		super();
		this.userid = userid;
		this.start = start;
		this.end = end;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JmToken [userid=");
		builder.append(userid);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
	}

}
