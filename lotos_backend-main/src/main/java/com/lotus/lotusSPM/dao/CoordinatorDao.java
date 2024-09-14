package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Coordinator;

@Repository
public interface CoordinatorDao extends JpaRepository<Coordinator,Long>,CrudRepository<Coordinator,Long>{

	Coordinator findByUsername(String username);
	
}
