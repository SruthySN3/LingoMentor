package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Course;
import com.canddella.entity.EnrollmentDetails;
import com.canddella.entity.Student;

public class EnrollmentDetailsDAOImp implements EnrollmentDetailsDAO {

	@Override
	public void addEnrollmentDetails(EnrollmentDetails enrollmentDetails) {
		// TODO Auto-generated method stub

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into enrollment (enrollment_id,preferredtime,student_id,course_code)"
					+ "values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, enrollmentDetails.getEnrollmentId());
			statement.setString(2, enrollmentDetails.getPreferredTime());
			statement.setString(3, enrollmentDetails.getStudent().getStudentId());
			statement.setString(4, enrollmentDetails.getCourse().getCourseCode());

			int result = statement.executeUpdate();
			if (result == 1)
				System.out.println("Enrollment details added successfully!");
			else
				System.out.println("Enrollment not added");

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<EnrollmentDetails> listAllEnrollmentDetails() {
		// TODO Auto-generated method stub

		ArrayList<EnrollmentDetails> enrollmentDetailsList = new ArrayList();

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from enrollment";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String enrollmentId = resultSet.getString("enrollment_id");
				String preferredTime = resultSet.getString("preferredtime");

				String studentId = resultSet.getString("student_id");
				Student student = new Student();
				student.setStudentId(studentId);
				String courseCode = resultSet.getString("course_code");

				Course course = new Course();
				course.setCourseCode(courseCode);

				EnrollmentDetails enrollmentDetails = new EnrollmentDetails(enrollmentId, preferredTime, student,
						course);
				enrollmentDetailsList.add(enrollmentDetails);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return enrollmentDetailsList;
	}

}
