package com.canddella.service;

import java.util.List;

import com.canddella.entity.EnrollmentDetails;

public interface EnrollmentDetailsService {

	public void addEnrollmentDetails(EnrollmentDetails enrollmentDetails);
	public List<EnrollmentDetails>listAllEnrollmentDetails();
}
