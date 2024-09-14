package com.lotus.lotusSPM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.lotusSPM.dao.CoordinatorDao;
import com.lotus.lotusSPM.model.Coordinator;
import com.lotus.lotusSPM.model.Instructor;
import com.lotus.lotusSPM.service.base.CoordinatorService;


@Service
@Transactional(rollbackFor = Exception.class)
public class CoordinatorServiceImpl implements CoordinatorService {

	private CoordinatorDao coordinatorDao;

	@Autowired
	public void setCoordinatorDao(CoordinatorDao coordinatorDao) {
		this.coordinatorDao = coordinatorDao;
	}

	@Override
	public List<Coordinator> findCoordinators() {
		return coordinatorDao.findAll();
	}

	@Override
	public Coordinator findCoordinatorById(Long id) {
		Optional<Coordinator> coor = coordinatorDao.findById(id);
		return coor.get();
	}

	@Override
	public Coordinator createCoordinator(Coordinator coor) {
		return coordinatorDao.save(coor);
	}

	@Override
	public void deleteCoordinator(Long id) {
		coordinatorDao.deleteById(id);		
	}

	@Override
	public Coordinator findByUsername(String username) {
		return coordinatorDao.findByUsername(username);
	}

	@Override
	public Coordinator save(Coordinator coor) {
		return coordinatorDao.save(coor);
	}

	
}
