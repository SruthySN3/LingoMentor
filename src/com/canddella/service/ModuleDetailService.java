package com.canddella.service;

import java.util.List;

import com.canddella.entity.ModuleDetails;

public interface ModuleDetailService {

	ModuleDetails searchModuleDetails(String mdSlno);

	public void addmoduleDetails(ModuleDetails moduleDetails);

	public void updatemoduleDetails(ModuleDetails moduleDetails);

	public List<ModuleDetails> listAllModuleDetails();

	public List<ModuleDetails> getModuleDetails(String courseCode);

}
