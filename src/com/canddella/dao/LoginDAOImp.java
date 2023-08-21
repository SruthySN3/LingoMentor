package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.LoginDetail;

public class LoginDAOImp implements LoginDAO {

	@Override
	public void addUserDetail(LoginDetail loginDetail) {
		// TODO Auto-generated method stub

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			String sqlQuery = "INSERT INTO login_table (user_name, password, user_role) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, loginDetail.getUserName());
			statement.setString(2, loginDetail.getPassword());
			statement.setString(3, loginDetail.getUserRole());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public LoginDetail getUserRoleByUserName(String userName, String password) {
		LoginDetail userRole = null;

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "SELECT user_role FROM login_table WHERE user_name = ? AND password = ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, userName);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String retrievedUserRole = resultSet.getString("user_role");
				userRole = new LoginDetail(-1, userName, password, retrievedUserRole);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userRole;
	}
}