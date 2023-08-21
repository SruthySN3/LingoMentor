package com.canddella.service;

import com.canddella.entity.LoginDetail;

public interface LoginService {
	public void addUserDetail(LoginDetail loginDetail);

	LoginDetail getUserRoleByUserName(String userName, String password);
}
