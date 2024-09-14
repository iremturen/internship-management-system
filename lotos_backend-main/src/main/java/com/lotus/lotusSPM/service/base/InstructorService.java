package com.lotus.lotusSPM.service.base;

import java.util.List;

import com.lotus.lotusSPM.model.Instructor;


public interface InstructorService {
	List<Instructor> findInstructors();
	Instructor findByUsername(String username);

}
