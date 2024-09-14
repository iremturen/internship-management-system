package com.lotus.lotusSPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.ApplicationForm;

@Repository
public interface ApplicationFormDao extends JpaRepository< ApplicationForm, String>, CrudRepository< ApplicationForm, String> {

}
