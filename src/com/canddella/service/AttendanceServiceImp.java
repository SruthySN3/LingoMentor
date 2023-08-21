package com.canddella.service;

import java.util.List;

import com.canddella.dao.AttendanceDAOImp;
import com.canddella.entity.AttendanceDetail;

public class AttendanceServiceImp implements AttendanceService {

	AttendanceDAOImp attendanceDAOImp = new AttendanceDAOImp();

	@Override
	public void addAttendance(AttendanceDetail attendanceDetail) {
		// TODO Auto-generated method stub
		attendanceDAOImp.addAttendance(attendanceDetail);

	}

	@Override
	public List<AttendanceDetail> listAllAttendanceDetails() {
		// TODO Auto-generated method stub
		return attendanceDAOImp.listAllAttendanceDetails();
	}

}
