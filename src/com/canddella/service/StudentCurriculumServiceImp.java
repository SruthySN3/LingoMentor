package com.canddella.service;

import java.time.LocalDate;
import java.util.List;

import com.canddella.dao.StudentCurriculumDAOImp;
import com.canddella.entity.Student;
import com.canddella.entity.StudentCurriculum;

public class StudentCurriculumServiceImp implements StudentCurriculumService {

	StudentCurriculumDAOImp studentCurriculumDAOImp = new StudentCurriculumDAOImp();

	@Override
	public void addDetailsIntoStudentCurriculum(StudentCurriculum studentCurriculum) {
		// TODO Auto-generated method stub
		studentCurriculumDAOImp.addDetailsIntoStudentCurriculum(studentCurriculum);
	}

	@Override
	public List<StudentCurriculum> listAllStudentCurriculum() {
		// TODO Auto-generated method stub
		return studentCurriculumDAOImp.listAllStudentCurriculum();
	}

	@Override
	public LocalDate getDateFromCurriculum(int curriculumId) {
		// TODO Auto-generated method stub
		return studentCurriculumDAOImp.getDateFromCurriculum(curriculumId);
	}

	@Override
	public List<LocalDate> getAbsentDatesByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentCurriculumDAOImp.getAbsentDatesByStudentId(studentId);
	}

	public List<StudentCurriculum> getCurriculumDetailsByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentCurriculumDAOImp.getCurriculumDetailsByStudentId(studentId);
	}

	@Override
	public List<Student> getStudentNameByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		return studentCurriculumDAOImp.getStudentNameByTeacherId(teacherId);
	}

}
