package com.canddella.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class StudentCurriculum {

	private int slNo;
	private LocalDate date;
	private LocalTime time;
	private Student student;
	private Course course;
	private Teacher teacher;
	private ModuleDetails moduleDetails;
	private String studentId;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public StudentCurriculum(String studentId) {
		super();
		this.studentId = studentId;
	}

	public StudentCurriculum(int slNo, LocalDate date, LocalTime time, Student student, Course course, Teacher teacher,
			ModuleDetails moduleDetails) {
		super();
		this.slNo = slNo;
		this.date = date;
		this.time = time;
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.moduleDetails = moduleDetails;
	}

	public StudentCurriculum(LocalDate date, LocalTime time, Student student, Course course, Teacher teacher,
			ModuleDetails moduleDetails) {
		super();
		this.date = date;
		this.time = time;
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.moduleDetails = moduleDetails;
	}

	public StudentCurriculum() {
		// TODO Auto-generated constructor stub
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ModuleDetails getModuleDetails() {
		return moduleDetails;
	}

	public void setModuleDetails(ModuleDetails moduleDetails) {
		this.moduleDetails = moduleDetails;
	}
}
