package com.lotus.lotusSPM.service.base;

import java.util.List;

import com.lotus.lotusSPM.model.Admin;

public interface AdminService {
	
	List<Admin> findAdmins();
	Admin findAdminById(Long id);
	Admin createAdmin(Admin admin);
	void deleteAdmin(Long id);
	Admin findByUsername(String username);


	
}
