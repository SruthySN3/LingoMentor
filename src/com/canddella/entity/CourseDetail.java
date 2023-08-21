package com.canddella.entity;

public class CourseDetail {

	private String cdSlNo;
	private String level;
	private Course course;
	public CourseDetail(String cdSlNo, String level, Course course) {
		super();
		this.cdSlNo = cdSlNo;
		this.level = level;
		this.course = course;
	}
	public CourseDetail() {
		// TODO Auto-generated constructor stub
	
	}
	public String getCdSlNo() {
		return cdSlNo;
	}
	public void setCdSlNo(String cdSlNo) {
		this.cdSlNo = cdSlNo;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	}