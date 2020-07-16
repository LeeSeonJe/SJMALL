package com.sj.shoppingMall.common.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String id;
	private String pwd;
	private String email;
	private char kind;
	private char status;
	private Date enrollDate;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberNo, String id, String pwd, String email, char kind, char status, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.kind = kind;
		this.status = status;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getKind() {
		return kind;
	}

	public void setKind(char kind) {
		this.kind = kind;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", kind=" + kind
				+ ", status=" + status + ", enrollDate=" + enrollDate + "]";
	}

}
