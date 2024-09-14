package com.lotus.lotusSPM.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lotus.lotusSPM.model.Messages;
import com.lotus.lotusSPM.model.OfficialLetter;

@Repository
public interface OfficialLetterDao extends JpaRepository<OfficialLetter, Long>, CrudRepository<OfficialLetter, Long>{

	OfficialLetter findByUsername(String username);
}
