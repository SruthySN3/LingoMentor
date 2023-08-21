package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Course;
import com.canddella.entity.ModuleDetails;
import com.canddella.entity.Student;
import com.canddella.entity.StudentCurriculum;
import com.canddella.entity.Teacher;

public class StudentCurriculumDAOImp implements StudentCurriculumDAO {
	@Override
	public void addDetailsIntoStudentCurriculum(StudentCurriculum studentCurriculum) {
		// TODO Auto-generated method stub
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "insert into student_curriculum (student_id, course_code, teacher_id, module_id, class_date, class_time)"
					+ " values ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, studentCurriculum.getStudent().getStudentId());
			statement.setString(2, studentCurriculum.getCourse().getCourseCode());
			statement.setString(3, studentCurriculum.getTeacher().getTeacherId());
			statement.setString(4, studentCurriculum.getModuleDetails().getModuleId());
			statement.setDate(5, Date.valueOf(studentCurriculum.getDate()));
			statement.setTime(6, Time.valueOf(studentCurriculum.getTime()));

			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<StudentCurriculum> listAllStudentCurriculum() {
		// TODO Auto-generated method stub
		ArrayList<StudentCurriculum> studentCurriculumList = new ArrayList<>();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "select * from student_curriculum";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int slno = resultSet.getInt("slno");
				String studentId = resultSet.getString("student_id");
				String courseCode = resultSet.getString("course_code");
				String teacherId = resultSet.getString("teacher_id");
				String moduleId = resultSet.getString("module_id");
				Date date = resultSet.getDate("class_date");
				Time time = resultSet.getTime("class_time");

				StudentCurriculum studentCurriculum = new StudentCurriculum();
				studentCurriculum.setSlNo(slno);

				studentCurriculumList.add(studentCurriculum);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return studentCurriculumList;
	}

	@Override
	public LocalDate getDateFromCurriculum(int curriculumId) {
		// TODO Auto-generated method stub
		LocalDate date = null;
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "select class_date from student_curriculum where slno = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, curriculumId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				date = LocalDate.parse(resultSet.getString("class_date"), format);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return date;

	}

	@Override
	public List<LocalDate> getAbsentDatesByStudentId(String studentId) {
		List<LocalDate> absentDates = new ArrayList<>();

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "SELECT  class_date FROM student_curriculum WHERE student_id = ? AND class_date NOT IN (SELECT class_date FROM attendance_tracking)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, studentId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate absentDate = resultSet.getDate("class_date").toLocalDate();
				absentDates.add(absentDate);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return absentDates;
	}

	@Override
	public List<StudentCurriculum> getCurriculumDetailsByStudentId(String studentId) {
		ArrayList<StudentCurriculum> curriculumList = new ArrayList<>();

		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "SELECT class_date, class_time, course_code, module_id, teacher_id FROM student_curriculum WHERE student_id = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, studentId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				LocalDate date = resultSet.getDate("class_date").toLocalDate();
				LocalTime time = resultSet.getTime("class_time").toLocalTime();
				String courseCode = resultSet.getString("course_code");
				String moduleId = resultSet.getString("module_id");
				String teacherId = resultSet.getString("teacher_id");

				Course course = new Course(courseCode);
				ModuleDetails moduleDetails = new ModuleDetails(moduleId);
				Teacher teacher = new Teacher(teacherId);

				StudentCurriculum curriculum = new StudentCurriculum();
				curriculum.setStudentId(studentId);
				curriculum.setDate(date);
				curriculum.setTime(time);
				curriculum.setCourse(course);
				curriculum.setModuleDetails(moduleDetails);
				curriculum.setTeacher(teacher);

				curriculumList.add(curriculum);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return curriculumList;
	}

	@Override
	public List<Student> getStudentNameByTeacherId(String teacherId) {
		List<Student> students = new ArrayList<>();

		try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
			String sqlQuery = "SELECT DISTINCT student.first_name FROM student "
					+ "JOIN student_curriculum ON student.student_id = student_curriculum.student_id "
					+ "WHERE teacher_id = ?";

			try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
				statement.setString(1, teacherId);

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String firstName = resultSet.getString("first_name");
						// Create a Student object or just add to the list as per your needs
						Student student = new Student();
						student.setFirstName(firstName);
						students.add(student);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
}