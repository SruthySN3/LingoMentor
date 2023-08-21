package com.canddella.service;

import java.util.List;

import com.canddella.dao.ModuleDetailsDAOImp;
import com.canddella.entity.ModuleDetails;

public class ModuleDetailServiceImp implements ModuleDetailService {
	ModuleDetailsDAOImp moduleDetailsDAOImp = new ModuleDetailsDAOImp();

	@Override
	public ModuleDetails searchModuleDetails(String mdSlno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addmoduleDetails(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub
		moduleDetailsDAOImp.addModuleDetails(moduleDetails);
	}

	@Override
	public void updatemoduleDetails(ModuleDetails moduleDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ModuleDetails> listAllModuleDetails() {
		// TODO Auto-generated method stub

		return moduleDetailsDAOImp.listAllModuleDetails();
	}

	@Override
	public List<ModuleDetails> getModuleDetails(String courseCode) {
		// TODO Auto-generated method stub

		return moduleDetailsDAOImp.getModuleDetails(courseCode);
	}

}