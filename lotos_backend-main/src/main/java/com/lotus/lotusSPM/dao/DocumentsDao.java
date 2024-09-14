package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Documents;

@Repository
public interface DocumentsDao extends JpaRepository< Documents, String>, CrudRepository< Documents, String>{

}
