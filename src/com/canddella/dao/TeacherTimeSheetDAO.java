package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Teacher;
import com.canddella.entity.TeacherTimeSheet;

public interface TeacherTimeSheetDAO {

	public void addteacherTimeSheet(TeacherTimeSheet teacherTimeSheet);

	public List<TeacherTimeSheet> listAllTeacherTimeSheet();

	public List<Teacher> checkAvailability(String preferredTime);
}
