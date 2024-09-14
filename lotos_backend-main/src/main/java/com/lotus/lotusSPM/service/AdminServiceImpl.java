package com.lotus.lotusSPM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lotus.lotusSPM.dao.AdminDao;
import com.lotus.lotusSPM.model.Admin;
import com.lotus.lotusSPM.service.base.AdminService;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Admin> findAdmins() {
		return adminDao.findAll();
	}

	@Override
	public Admin findAdminById(Long id) {
		Optional<Admin> admin = adminDao.findById(id);
		return admin.get();
	}

	@Override
	public Admin createAdmin(Admin admin) {
		return adminDao.save(admin);
	}

	@Override
	public void deleteAdmin(Long id) {
		adminDao.deleteById(id);
	}

	@Override
	public Admin findByUsername(String username) {
		return adminDao.findByUsername(username);
	}

}
