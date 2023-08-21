package com.canddella.entity;

public class LoginDetail {

	private int loginId;
	private String userName;
	private String password;
	private String userRole;

	public LoginDetail(int loginId, String userName, String password, String userRole) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
