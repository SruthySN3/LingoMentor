package com.canddella.service;

import com.canddella.dao.LoginDAOImp;
import com.canddella.entity.LoginDetail;

public class LoginServiceImp implements LoginService {
	LoginDAOImp loginDAOImp = new LoginDAOImp();
	@Override
	public void addUserDetail(LoginDetail loginDetail) {
		// TODO Auto-generated method stub
		loginDAOImp.addUserDetail(loginDetail);
	}

	@Override
	public LoginDetail getUserRoleByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		return loginDAOImp.getUserRoleByUserName(userName, password);
	}

}
