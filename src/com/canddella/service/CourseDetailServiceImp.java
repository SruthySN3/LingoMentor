package com.canddella.service;

import java.util.List;

import com.canddella.dao.CourseDetailDAOImp;
import com.canddella.entity.CourseDetail;

public class CourseDetailServiceImp implements CourseDetailService {
	CourseDetailDAOImp courseDetailDAOImp = new CourseDetailDAOImp();
	@Override
	public CourseDetail searchCourseDetail(String slNo) {
		// TODO Auto-generated method stub
		return courseDetailDAOImp.searchCourseDetail(slNo);
	}

	@Override
	public void addCourseDetail(CourseDetail courseDetail) {
		// TODO Auto-generated method stub
		courseDetailDAOImp.addCourseDetail(courseDetail);
	}

	@Override
	public void updateCourseDetail(CourseDetail courseDetail) {
		// TODO Auto-generated method stub
		courseDetailDAOImp.updateCourseDetail(courseDetail);
	}

	@Override
	public List<CourseDetail> listAllCourseDetail() {
		// TODO Auto-generated method stub
		return courseDetailDAOImp.listAllCourseDetail();
	}

}
