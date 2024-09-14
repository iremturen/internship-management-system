package com.lotus.lotusSPM.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Admin;
import com.lotus.lotusSPM.model.Messages;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>, CrudRepository<Admin, Long> {

Admin findByUsername(String username);

}
