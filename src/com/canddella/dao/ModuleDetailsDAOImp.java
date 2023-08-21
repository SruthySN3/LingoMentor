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
import com.canddella.entity.CourseDetail;
import com.canddella.entity.ModuleDetails;

public class ModuleDetailsDAOImp implements ModuleDetailsDAO {

	@Override
	public ModuleDetails searchModuleDetails(String mdSlno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addModuleDetails(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "INSERT INTO module_details (module_id,  module_name,module_description,time, cd_slno,course_code) VALUES (?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, moduleDetails.getModuleId());
			statement.setString(2, moduleDetails.getModuleName());
			statement.setString(3, moduleDetails.getModuleDescription());
			statement.setInt(4, moduleDetails.getTime());
			statement.setString(5, moduleDetails.getCourseDetail().getCdSlNo());
			statement.setString(6, moduleDetails.getCourse().getCourseCode());

			statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateModuleDetails(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ModuleDetails> listAllModuleDetails() {
		// TODO Auto-generated method stub
		ArrayList<ModuleDetails> moduleDetailList = new ArrayList();
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "SELECT * FROM module_details";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String moduleId = resultSet.getString("module_id");
				String moduleName = resultSet.getString("module_name");
				String moduleDescription = resultSet.getString("module_description");
				int time = resultSet.getInt("time");
				String cdSlNo = resultSet.getString("cd_slno");
				CourseDetail courseDetail = new CourseDetail();
				courseDetail.setCdSlNo(cdSlNo);
				String courseCode = resultSet.getString("course_code");
				Course course = new Course();
				course.setCourseCode(courseCode);
				ModuleDetails moduleDetails = new ModuleDetails(moduleId, moduleName, moduleDescription, time,
						courseDetail,course);
				moduleDetailList.add(moduleDetails);

			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}
		return moduleDetailList;
}

	@Override
	public List<ModuleDetails> getModuleDetails(String courseCode) {
		// TODO Auto-generated method stub
		
		List<ModuleDetails> moduleDetailsList = new ArrayList<>();
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "select module_id from module_details where course_code = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, courseCode);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String moduleId = resultSet.getString("module_id");

				ModuleDetails moduleDetails = new ModuleDetails();
				moduleDetails.setModuleId(moduleId);
				moduleDetailsList.add(moduleDetails);

			}

			connection = ds.getConnection();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());
		}

		return moduleDetailsList;
	}


}