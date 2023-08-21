package com.canddella.dao;

import java.util.List;

import com.canddella.entity.EnrollmentDetails;

public interface EnrollmentDetailsDAO {
	public void addEnrollmentDetails(EnrollmentDetails enrollmentDetails);

	public List<EnrollmentDetails> listAllEnrollmentDetails();
}
