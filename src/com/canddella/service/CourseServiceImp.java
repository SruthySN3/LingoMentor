package com.canddella.service;

import java.util.List;

import com.canddella.dao.CourseDAOImp;
import com.canddella.entity.Course;

public class CourseServiceImp implements CourseService {

	CourseDAOImp courseDAOImp = new CourseDAOImp();

	@Override
	public Course searchCourse(String course_code) {
		// TODO Auto-generated method stub
		return courseDAOImp.searchCourse(course_code);
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAOImp.addCourse(course);
	}

	@Override
	public void updateCourse(Course cousre) {
		// TODO Auto-generated method stub
		courseDAOImp.updateCourse(cousre);
	}

	@Override
	public List<Course> listAllCourse() {
		// TODO Auto-generated method stub
		return courseDAOImp.listAllCourse();
	}

}
