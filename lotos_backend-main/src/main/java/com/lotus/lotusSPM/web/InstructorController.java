package com.lotus.lotusSPM.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lotus.lotusSPM.model.Coordinator;
import com.lotus.lotusSPM.model.Instructor;
import com.lotus.lotusSPM.service.base.InstructorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/instructors")
	public ResponseEntity<Object> getInstructors() {
		List<Instructor> instructors = instructorService.findInstructors();
		return ResponseEntity.ok(instructors);
	}
}
