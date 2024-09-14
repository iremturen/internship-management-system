package com.lotus.lotusSPM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.lotusSPM.dao.InstructorDao;
import com.lotus.lotusSPM.model.Instructor;
import com.lotus.lotusSPM.service.base.InstructorService;

@Service
@Transactional(rollbackFor = Exception.class)
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao instructorDao;

	@Override
	public List<Instructor> findInstructors() {
		return instructorDao.findAll();
	}

	@Override
	public Instructor findByUsername(String username) {
		return instructorDao.findByUsername(username);
	}

}
