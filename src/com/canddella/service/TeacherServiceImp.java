package com.canddella.service;

import java.util.List;

import com.canddella.dao.TeacherDAOImp;
import com.canddella.entity.Teacher;

public class TeacherServiceImp implements TeacherService {
	TeacherDAOImp teacherDAOImp = new TeacherDAOImp();

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAOImp.addTeacher(teacher);

	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAOImp.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> listAllTeacher() {
		// TODO Auto-generated method stub
		return teacherDAOImp.listAllTeacher();

	}

	@Override
	public Teacher searchTeacher(String teacher_id) {
		// TODO Auto-generated method stub
		return teacherDAOImp.searchteacher(teacher_id);
	}

}
