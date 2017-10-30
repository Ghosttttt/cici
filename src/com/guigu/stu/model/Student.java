package com.guigu.stu.model;

import java.util.Date;

public class Student {

	private int sid;

	private String username;

	private String password;

	private String sname;

	private int sage;

	private String gender;

	private String education;

	public Student() {
		super();
	}

	public Student(int sid, String username, String password, String sname,
			int sage, String gender, String education) {
		super();
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.sname = sname;
		this.sage = sage;
		this.gender = gender;
		this.education = education;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", username=" + username + ", password="
				+ password + ", sname=" + sname + ", sage=" + sage
				+ ", gender=" + gender + ", education=" + education + "]";
	}

}
