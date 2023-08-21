package com.canddella.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AttendanceDetail {

	private String attendanceId;
	private StudentCurriculum studentCurriculum;
	

	public AttendanceDetail(String attendanceId, StudentCurriculum studentCurriculum) {
		super();
		this.attendanceId = attendanceId;
		this.studentCurriculum = studentCurriculum;
	}


	

	public String getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}

	public StudentCurriculum getStudentCurriculum() {
		return studentCurriculum;
	}

	public void setStudentCurriculum(StudentCurriculum studentCurriculum) {
		this.studentCurriculum = studentCurriculum;
	}
}