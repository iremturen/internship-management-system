package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.CareerCenter;

@Repository
public interface CareerCenterDao extends JpaRepository<CareerCenter,Long>, CrudRepository<CareerCenter,Long> {
	
	CareerCenter findByUsername(String username);

}
