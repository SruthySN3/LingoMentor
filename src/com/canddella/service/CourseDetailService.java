package com.canddella.service;

import java.util.List;

import com.canddella.entity.CourseDetail;

public interface CourseDetailService {

	CourseDetail searchCourseDetail(String slNo);

	public void addCourseDetail(CourseDetail courseDetail);

	public void updateCourseDetail(CourseDetail courseDetail);

	public List<CourseDetail> listAllCourseDetail();

}
