package com.tech.auth.token.jmt.dto;

public class JmToken {
	
	private String userid;
	private String start;
	private String end;
	private String entity;
	
	public JmToken() {
		// TODO Auto-generated constructor stub
	}

	public JmToken(String userid) {
		super();
		this.userid = userid;
	}

	public JmToken(String userid, String entity) {
		super();
		this.userid = userid;
		this.entity = entity;
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

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
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
		builder.append(", entity=");
		builder.append(entity);
		builder.append("]");
		return builder.toString();
	}

}
