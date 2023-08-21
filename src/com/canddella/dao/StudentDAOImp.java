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
import com.canddella.entity.Student;

public class StudentDAOImp implements StudentDAO {

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into student (student_id,first_name,last_name,date_of_birth,gender,address,phone_no,email)"
					+ "values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.setDate(4, Date.valueOf(student.getDateOfBirth()));
			statement.setString(5, student.getGender());
			statement.setString(6, student.getAddress());
			statement.setLong(7, student.getPhoneNo());
			statement.setString(8, student.getEmail());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "UPDATE student SET first_name=?,last_name=?,date_of_birth=?,gender=?,address=?,phone_no=?,email=?WHERE student_id=?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setDate(3, Date.valueOf(student.getDateOfBirth()));
			statement.setString(4, student.getGender());
			statement.setString(5, student.getAddress());
			statement.setLong(6, student.getPhoneNo());
			statement.setString(7, student.getEmail());
			statement.setString(8, student.getStudentId());
			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Student> listAllStudent() {
		// TODO Auto-generated method stub

		ArrayList<Student> studentList = new ArrayList();

		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from student";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate date_of_birth = LocalDate.parse(resultSet.getString(4), format);
				Student student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						date_of_birth, resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7),
						resultSet.getString(8));
				studentList.add(student);

			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return studentList;
	}

	@Override
	public Student searchStudent(String student_id) {
		// TODO Auto-generated method stub
		Student student = null;
		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "select * from student where student_id =?";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, student_id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String studentId = resultSet.getString("student_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("date_of_birth"), format);
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Long phoneNo = resultSet.getLong("phone_no");
				String email = resultSet.getString("email");

				student = new Student(studentId, firstName, lastName, dateOfBirth, gender, address, phoneNo, email);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return student;
	}

}