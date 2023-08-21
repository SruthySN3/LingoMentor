package com.canddella.service;

import java.util.List;

import com.canddella.entity.Course;

public interface CourseService {
	Course searchCourse(String course_code);

	public void addCourse(Course course);

	public void updateCourse(Course cousre);

	public List<Course> listAllCourse();

}
