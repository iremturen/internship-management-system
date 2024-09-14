package com.lotus.lotusSPM.service.base;

import java.util.List;

import com.lotus.lotusSPM.model.Coordinator;

public interface CoordinatorService {

	List<Coordinator> findCoordinators();
	Coordinator findCoordinatorById(Long id);
	Coordinator createCoordinator(Coordinator coor);
	void deleteCoordinator(Long id);
	Coordinator findByUsername(String username);
	Coordinator save(Coordinator ins);

	}
