package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Teacher;
import com.canddella.entity.TeacherTimeSheet;

public class TeacherTimeSheetDAOImp implements TeacherTimeSheetDAO {

	@Override
	public void addteacherTimeSheet(TeacherTimeSheet teacherTimeSheet) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into teacher_timesheet (tt_slno,available_time,class_duration,availability,teacher_id)"
					+ "values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, teacherTimeSheet.getTtSlNo());
			statement.setString(2, teacherTimeSheet.getAvailableTime());
			statement.setInt(3, teacherTimeSheet.getClassDuration());
			statement.setString(4, teacherTimeSheet.getTeacherAvailability());
			statement.setString(5, teacherTimeSheet.getTeacher().getTeacherId());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<TeacherTimeSheet> listAllTeacherTimeSheet() {
		// TODO Auto-generated method stub
		ArrayList<TeacherTimeSheet> teacherTimeSheetList = new ArrayList();

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from teacher_timesheet";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String ttId = resultSet.getString("tt_slno");
				String availableTime = resultSet.getString("available_time");
				int classDuration = resultSet.getInt("class_duration");
				String teacherAvailability = resultSet.getString("availability");
				String teacherId = resultSet.getString("teacher_id");
				Teacher teacher = new Teacher();
				teacher.setTeacherId(teacherId);

				TeacherTimeSheet teacherTimeSheet = new TeacherTimeSheet(ttId, availableTime, classDuration,
						teacherAvailability, teacher);
				teacherTimeSheetList.add(teacherTimeSheet);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return teacherTimeSheetList;
	}

	@Override
	public List<Teacher> checkAvailability(String preferredTime) {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "SELECT * FROM teacher_timesheet WHERE availability = 'y'";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String teacherId = resultSet.getString("teacher_id");
			
				Teacher teacher = new Teacher();
				teacher.setTeacherId(teacherId);
				teacherList.add(teacher);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return teacherList;
	}
}
