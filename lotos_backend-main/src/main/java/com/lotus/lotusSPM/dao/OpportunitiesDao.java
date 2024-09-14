package com.lotus.lotusSPM.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Opportunities;
import com.lotus.lotusSPM.model.Student;

@Repository
public interface OpportunitiesDao extends JpaRepository<Opportunities, Long>, CrudRepository<Opportunities, Long> {

	Opportunities findByUsername(String id);
	



}
