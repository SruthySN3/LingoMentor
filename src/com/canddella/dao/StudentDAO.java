package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Student;

public interface StudentDAO {
	
	Student searchStudent (String student_id);

	public void addStudent(Student student);

	public void updateStudent(Student student);

	public List<Student> listAllStudent();

}
