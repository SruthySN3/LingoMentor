package com.canddella.service;

import java.util.List;

import com.canddella.entity.Teacher;
import com.canddella.entity.TeacherTimeSheet;

public interface TeacherTimeSheetService {
	public void addteacherTimeSheet(TeacherTimeSheet teacherTimeSheet);

	public List<TeacherTimeSheet> listAllTeacherTimeSheet();
	public List<Teacher> checkAvailability(String preferredTime);

}
