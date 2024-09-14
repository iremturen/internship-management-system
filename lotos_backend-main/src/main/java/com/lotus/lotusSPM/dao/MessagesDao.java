package com.lotus.lotusSPM.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Messages;

@Repository
public interface MessagesDao extends JpaRepository< Messages, Long>, CrudRepository< Messages, Long>{

	 
	List<Messages> findByTo(String to);
	List<Messages> findByFrom(String from);


}
