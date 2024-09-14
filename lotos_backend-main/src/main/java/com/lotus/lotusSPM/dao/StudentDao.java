package com.lotus.lotusSPM.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>, CrudRepository<Student, Long> {

	Student findByUsername(String username);

}
