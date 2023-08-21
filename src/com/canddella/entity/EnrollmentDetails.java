package com.canddella.entity;

public class EnrollmentDetails {
	private String enrollmentId;
	private String preferredTime;
	private Student student;
	private Course course;

	public EnrollmentDetails(String enrollmentId, String preferredTime, Student student, Course course) {
		super();
		this.enrollmentId = enrollmentId;
		this.preferredTime = preferredTime;
		this.student = student;
		this.course = course;
	}

	

	public EnrollmentDetails() {
		// TODO Auto-generated constructor stub
	}



	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
