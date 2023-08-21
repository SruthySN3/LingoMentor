package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Teacher;

public interface TeacherDAO {

	Teacher searchteacher(String teacher_id);

	public void addTeacher(Teacher teacher);

	public void updateTeacher(Teacher teacher);

	public List<Teacher> listAllTeacher();

}
