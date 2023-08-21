package com.canddella.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Teacher {

	private String teacherId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String address;
	private Long phoneNo;
	private String email;
	private String experience;

	public Teacher(String teacherId, String firstName, String lastName, LocalDate dateOfBirth, String gender,
			String address, Long phoneNo, String email, String experience) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.experience = experience;
	}

	public Teacher(String teacherId) {
		super();
		this.teacherId = teacherId;
	}

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String ttId, String availableTime, int classDuration, String teacherAvailability,
			String teacherId2) {
		// TODO Auto-generated constructor stub
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phnoneNo) {
		this.phoneNo = phnoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}