package com.canddella.entity;

public class Course {

	private String courseCode;
	private String courseName;
	private String courseDuration;
	private Long courseFee;

	public Course(String courseCode, String courseName, String courseDuration, Long courseFee) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFee=courseFee;
	}

	
	
	public Course(String courseCode) {
		super();
		this.courseCode = courseCode;
	}



	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Long getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Long courseFee) {
		this.courseFee = courseFee;
	}

}
