package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Instructor;


@Repository
public interface InstructorDao extends JpaRepository<Instructor, Long>, CrudRepository<Instructor, Long>{

	Instructor findByUsername(String username);

}
