package com.lotus.lotusSPM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.lotusSPM.dao.CareerCenterDao;
import com.lotus.lotusSPM.model.CareerCenter;
import com.lotus.lotusSPM.service.base.CareerCenterService;




@Service
@Transactional(rollbackFor = Exception.class)
public class CareerCenterServiceImpl implements CareerCenterService{

	CareerCenterDao careerCenterDao;
	
	@Autowired
	public void setCareerCenterDao(CareerCenterDao careerCenterDao) {
		this.careerCenterDao = careerCenterDao;
	}

	@Override
	public List<CareerCenter> findCareerCenters() {
		return careerCenterDao.findAll();
	}

	@Override
	public CareerCenter findCareerCenterById(Long id) {
		Optional<CareerCenter> cc = careerCenterDao.findById(id);
		return cc.get();
	}

	@Override
	public CareerCenter createCareerCenter(CareerCenter cc) {
		return careerCenterDao.save(cc);
	}

	@Override
	public void deleteCareerCenter(Long id) {
		careerCenterDao.deleteById(id);
	}

	@Override
	public CareerCenter findByUsername(String username) {
		return careerCenterDao.findByUsername(username);
	}

	

	
	
}
