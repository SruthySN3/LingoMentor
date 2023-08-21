package com.canddella.service;

import java.util.List;

import com.canddella.dao.StudentCurriculumDAO;
import com.canddella.dao.StudentCurriculumDAOImp;
import com.canddella.entity.Student;

public interface StudentService {

	Student searchStudent(String student_id);

	public void addStudent(Student student);

	public void updateStudent(Student student);

	public List<Student> listAllStudent();

	StudentCurriculumDAO studentCurriculumDAO = new StudentCurriculumDAOImp();

	public static List<Student> getStudentNameByTeacherId(String teacherId) {
		return studentCurriculumDAO.getStudentNameByTeacherId(teacherId);
	}
}