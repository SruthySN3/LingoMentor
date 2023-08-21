package com.canddella.dao;

import java.util.List;

import com.canddella.entity.CourseDetail;

public interface CourseDetailDAO {

	CourseDetail searchCourseDetail(String cd_slno);

	public void addCourseDetail(CourseDetail courseDetail);

	public void updateCourseDetail(CourseDetail courseDetail);

	public List<CourseDetail> listAllCourseDetail();
}
