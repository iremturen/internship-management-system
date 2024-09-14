package com.lotus.lotusSPM.service.base;

import java.util.List;

import com.lotus.lotusSPM.model.CareerCenter;

public interface CareerCenterService {

	List<CareerCenter> findCareerCenters();
	CareerCenter findCareerCenterById(Long id) ;
	CareerCenter createCareerCenter(CareerCenter stock);
	void deleteCareerCenter(Long id);
	CareerCenter findByUsername(String username);
	
}
