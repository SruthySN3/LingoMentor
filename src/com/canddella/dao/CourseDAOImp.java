package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Course;

public class CourseDAOImp implements CourseDAO {

	@Override
	public Course searchCourse(String course_code) {
		// TODO Auto-generated method stub
		Course course = null;
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from course where course_code =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, course_code);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");
				String courseDuration = resultSet.getString("course_duration");
				Long courseFee = resultSet.getLong("course_fee");

				course = new Course(courseCode, courseName, courseDuration, courseFee);

			

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return course;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		try {

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into course (course_code,course_name,course_duration,course_fee)"
					+ "values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getCourseDuration());
			statement.setLong(4, course.getCourseFee());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "UPDATE course SET course_name=?, course_duration=?, course_fee=? WHERE course_code=?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, course.getCourseName());
			statement.setString(2, course.getCourseDuration());
			statement.setLong(3, course.getCourseFee());
			statement.setString(4, course.getCourseCode());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Course> listAllCourse() {
		// TODO Auto-generated method stub

		ArrayList<Course> courseList = new ArrayList();

		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from course";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Course course = new Course(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getLong(4));

				courseList.add(course);

			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return courseList;
	}

}
