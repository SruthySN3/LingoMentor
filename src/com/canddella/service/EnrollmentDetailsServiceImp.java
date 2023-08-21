package com.canddella.service;

import java.util.List;

import com.canddella.dao.EnrollmentDetailsDAOImp;
import com.canddella.entity.EnrollmentDetails;

public class EnrollmentDetailsServiceImp implements EnrollmentDetailsService {
	EnrollmentDetailsDAOImp enrollmentDetailsDAOImp = new EnrollmentDetailsDAOImp();

	@Override
	public void addEnrollmentDetails(EnrollmentDetails enrollmentDetails) {
		// TODO Auto-generated method stub
		enrollmentDetailsDAOImp.addEnrollmentDetails(enrollmentDetails);
	}

	@Override
	public List<EnrollmentDetails> listAllEnrollmentDetails() {
		// TODO Auto-generated method stub
		return enrollmentDetailsDAOImp.listAllEnrollmentDetails();
	}

}
