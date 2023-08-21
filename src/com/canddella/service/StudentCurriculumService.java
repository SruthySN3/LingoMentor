package com.canddella.service;

import java.time.LocalDate;
import java.util.List;

import com.canddella.entity.Student;
import com.canddella.entity.StudentCurriculum;

public interface StudentCurriculumService {
	public void addDetailsIntoStudentCurriculum(StudentCurriculum studentCurriculum);

	public List<StudentCurriculum> listAllStudentCurriculum();
	public LocalDate getDateFromCurriculum(int curriculumId);
	List<LocalDate> getAbsentDatesByStudentId(String studentId);
	public List<Student>getStudentNameByTeacherId(String teacherId);


}
