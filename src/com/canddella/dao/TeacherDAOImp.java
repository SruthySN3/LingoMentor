package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Teacher;

public class TeacherDAOImp implements TeacherDAO {

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into teacher (teacher_id,first_name,last_name,date_of_birth,gender,address,phone_no,email,experience)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, teacher.getTeacherId());
			statement.setString(2, teacher.getFirstName());
			statement.setString(3, teacher.getLastName());
			statement.setDate(4, Date.valueOf(teacher.getDateOfBirth()));
			statement.setString(5, teacher.getGender());
			statement.setString(6, teacher.getAddress());
			statement.setLong(7, teacher.getPhoneNo());
			statement.setString(8, teacher.getEmail());
			statement.setString(9, teacher.getExperience());
			statement.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "UPDATE teacher SET first_name=?,last_name=?,date_of_birth=?,gender=?,address=?,phone_no=?,email=?,experience=?WHERE teacher_id=?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, teacher.getFirstName());
			statement.setString(2, teacher.getLastName());
			statement.setDate(3, Date.valueOf(teacher.getDateOfBirth()));
			statement.setString(4, teacher.getGender());
			statement.setString(5, teacher.getAddress());
			statement.setLong(6, teacher.getPhoneNo());
			statement.setString(7, teacher.getEmail());
			statement.setString(8, teacher.getExperience());

			statement.setString(9, teacher.getTeacherId());
			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Teacher> listAllTeacher() {
		// TODO Auto-generated method stub
		ArrayList<Teacher> teacherList = new ArrayList();

		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from teacher";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate date_of_birth = LocalDate.parse(resultSet.getString(4), format);
				Teacher teacher = new Teacher(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						date_of_birth, resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7),
						resultSet.getString(8), resultSet.getString(9));
				teacherList.add(teacher);

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return teacherList;

	}

	@Override
	public Teacher searchteacher(String teacher_id) {
		// TODO Auto-generated method stub
		Teacher teacher = null;
		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from teacher where teacher_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, teacher_id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String teacherId = resultSet.getString("teacher_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("date_of_birth"), format);
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Long phoneNo = resultSet.getLong("phone_no");
				String email = resultSet.getString("email");
				String experience = resultSet.getString("experience");

				teacher = new Teacher(teacherId, firstName, lastName, dateOfBirth, gender, address, phoneNo, email,
						experience);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return teacher;
	}

}
