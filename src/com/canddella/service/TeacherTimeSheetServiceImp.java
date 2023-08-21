package com.canddella.service;

import java.util.List;

import com.canddella.dao.TeacherTimeSheetDAOImp;
import com.canddella.entity.Teacher;
import com.canddella.entity.TeacherTimeSheet;

public class TeacherTimeSheetServiceImp implements TeacherTimeSheetService {
	TeacherTimeSheetDAOImp teacherTimeSheetDAOImp = new TeacherTimeSheetDAOImp();

	@Override
	public void addteacherTimeSheet(TeacherTimeSheet teacherTimeSheet) {
		// TODO Auto-generated method stub
		teacherTimeSheetDAOImp.addteacherTimeSheet(teacherTimeSheet);
	}

	@Override
	public List<TeacherTimeSheet> listAllTeacherTimeSheet() {
		// TODO Auto-generated method stub
		return teacherTimeSheetDAOImp.listAllTeacherTimeSheet();
	}

	public List<Teacher> checkAvailability(String preferredTime) {
		// TODO Auto-generated method stub
		return teacherTimeSheetDAOImp.checkAvailability(preferredTime);
	}

}
