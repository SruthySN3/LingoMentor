package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Course;
import com.canddella.entity.CourseDetail;
import com.canddella.entity.Student;

public class CourseDetailDAOImp implements CourseDetailDAO {

	@Override
	public void addCourseDetail(CourseDetail courseDetail) {
		// TODO Auto-generated method stub
		try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
			String sqlQuery = "INSERT INTO course_details (cd_slno, level,  course_code) VALUES (?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, courseDetail.getCdSlNo());
			statement.setString(2, courseDetail.getLevel());
			statement.setString(3, courseDetail.getCourse().getCourseCode());

			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateCourseDetail(CourseDetail courseDetail) {
		// TODO Auto-generated method stub
		try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
			String sqlQuery = "UPDATE course_details SET level=?, course_code=? WHERE cd_slno=?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, courseDetail.getLevel());
			statement.setString(2, courseDetail.getCourse().getCourseCode());
			statement.setString(3, courseDetail.getCdSlNo());

			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}
	}

	

	@Override
	public List<CourseDetail> listAllCourseDetail() {
		// TODO Auto-generated method stub
		ArrayList<CourseDetail> courseDetailList = new ArrayList();
		try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
			String sqlQuery = "SELECT * FROM course_details";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String cdslNo = resultSet.getString("cd_slno");
				String level = resultSet.getString("level");
				String courseCode = resultSet.getString("course_code");

				Course course = new Course();
				course.setCourseCode(courseCode);

				CourseDetail courseDetail = new CourseDetail(cdslNo, level, course);
				courseDetailList.add(courseDetail);

			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}

		return courseDetailList;
	}

	@Override
	public CourseDetail searchCourseDetail(String cd_slno) {
		// TODO Auto-generated method stub
		CourseDetail courseDetail = null;
		try (Connection connection = DBConnectionPool.getDataSource().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM course_details WHERE cd_slno = ?")) {

			statement.setString(1, cd_slno);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Course course = new Course();
					course.setCourseCode(resultSet.getString(2));

					String level = resultSet.getString("level");

					courseDetail = new CourseDetail(cd_slno, level, course);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return courseDetail;
	}
	
}
