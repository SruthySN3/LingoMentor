package com.canddella.service;

import java.util.List;

import com.canddella.entity.AttendanceDetail;

public interface AttendanceService {

	public void addAttendance (AttendanceDetail attendanceDetail);
	public List<AttendanceDetail>listAllAttendanceDetails ();
}
