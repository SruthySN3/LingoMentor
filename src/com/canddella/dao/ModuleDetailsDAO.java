package com.canddella.dao;

import java.util.List;

import com.canddella.entity.ModuleDetails;

public interface ModuleDetailsDAO {

	ModuleDetails searchModuleDetails(String mdSlno);

	public void addModuleDetails(ModuleDetails moduleDetails);

	public void updateModuleDetails(ModuleDetails moduleDetails);

	public List<ModuleDetails> listAllModuleDetails();

	public List<ModuleDetails> getModuleDetails(String courseCode);
}
