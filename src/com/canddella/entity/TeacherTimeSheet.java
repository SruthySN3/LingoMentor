package com.canddella.entity;

public class TeacherTimeSheet {

	private String ttSlNo;
	private String availableTime;
	private int classDuration;
	private String teacherAvailability;
	private Teacher teacher;
	public TeacherTimeSheet(String ttSlNo, String availableTime, int classDuration, String teacherAvailability,
			Teacher teacher) {
		super();
		this.ttSlNo = ttSlNo;
		this.availableTime = availableTime;
		this.classDuration = classDuration;
		this.teacherAvailability = teacherAvailability;
		this.teacher = teacher;
	}
	
	public String getTtSlNo() {
		return ttSlNo;
	}
	public void setTtSlNo(String ttSlNo) {
		this.ttSlNo = ttSlNo;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public int getClassDuration() {
		return classDuration;
	}
	public void setClassDuration(int classDuration) {
		this.classDuration = classDuration;
	}
	public String getTeacherAvailability() {
		return teacherAvailability;
	}
	public void setTeacherAvailability(String teacherAvailability) {
		this.teacherAvailability = teacherAvailability;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}