package com.canddella.dao;

import java.util.List;

import com.canddella.entity.AttendanceDetail;

public interface AttendanceDAO {

	public void addAttendance (AttendanceDetail attendanceDetail);
	public List<AttendanceDetail>listAllAttendanceDetails ();
}
