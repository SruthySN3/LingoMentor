package com.canddella.service;

import java.util.List;

import com.canddella.dao.StudentDAOImp;
import com.canddella.entity.Student;

public class StudentServiceImp implements StudentService {

	StudentDAOImp studentDAOImp = new StudentDAOImp();

	@Override
	public void addStudent(Student student) {
		studentDAOImp.addStudent(student);

	}



	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAOImp.updateStudent(student);
		
	}



	@Override
	public List<Student> listAllStudent() {
		// TODO Auto-generated method stub
		
		return studentDAOImp.listAllStudent();
	}



	@Override
	public Student searchStudent(String student_id) {
		// TODO Auto-generated method stub
		return studentDAOImp.searchStudent(student_id);
	}

	


	
	
}
