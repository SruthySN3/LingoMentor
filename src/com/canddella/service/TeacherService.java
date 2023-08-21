package com.canddella.service;

import java.util.List;

import com.canddella.entity.Teacher;

public interface TeacherService {

	Teacher searchTeacher(String teacher_id);

	public void addTeacher(Teacher teacher);

	public void updateTeacher(Teacher teacher);

	public List<Teacher> listAllTeacher();

}
