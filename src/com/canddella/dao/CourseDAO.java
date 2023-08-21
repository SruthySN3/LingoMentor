package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Course;

public interface CourseDAO {
	Course searchCourse(String course_code);

	public void addCourse(Course course);

	public void updateCourse(Course cousre);

	public List<Course> listAllCourse();
}
