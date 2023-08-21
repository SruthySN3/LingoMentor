package com.canddella.dao;

import com.canddella.entity.LoginDetail;

public interface LoginDAO {

	public void addUserDetail(LoginDetail loginDetail);

	LoginDetail getUserRoleByUserName(String userName, String password);
}
