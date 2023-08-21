package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.AttendanceDetail;
import com.canddella.entity.StudentCurriculum;

public class AttendanceDAOImp implements AttendanceDAO {

	 @Override
	    public void addAttendance(AttendanceDetail attendanceDetail) {
	        try {
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	            Connection connection = null;
	            DataSource ds = DBConnectionPool.getDataSource();
	            connection = ds.getConnection();
	            String sqlQuery = "INSERT INTO attendance_tracking (attendance_id, slno, class_date) VALUES (?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sqlQuery);
	            statement.setString(1, attendanceDetail.getAttendanceId());
	            statement.setInt(2, attendanceDetail.getStudentCurriculum().getSlNo());
	            statement.setDate(3, java.sql.Date.valueOf(attendanceDetail.getStudentCurriculum().getDate()));

	            statement.executeUpdate();

	            connection.close();

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    @Override
	    public List<AttendanceDetail> listAllAttendanceDetails() {
	        ArrayList<AttendanceDetail> attendanceDetailList = new ArrayList<>();
	        try {
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	            DataSource ds = DBConnectionPool.getDataSource();
	            Connection connection = ds.getConnection();
	            String sqlQuery = "SELECT * FROM attendance_tracking";
	            PreparedStatement statement = connection.prepareStatement(sqlQuery);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                String attendanceId = resultSet.getString("attendance_id");
	                int curriculumId = resultSet.getInt("slno");

	                LocalDate date = getDateFromCurriculum(curriculumId);

	                StudentCurriculum studentCurriculum = new StudentCurriculum();
	                studentCurriculum.setSlNo(curriculumId);
	                studentCurriculum.setDate(date);

	                AttendanceDetail attendanceDetail = new AttendanceDetail(attendanceId, studentCurriculum);
	                attendanceDetailList.add(attendanceDetail);
	            }

	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return attendanceDetailList;
	    }

	    private LocalDate getDateFromCurriculum(int curriculumId) {
	       
	        return LocalDate.now();
	    }
	}
