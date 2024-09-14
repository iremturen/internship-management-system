package com.lotus.lotusSPM.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lotus.lotusSPM.model.Coordinator;
import com.lotus.lotusSPM.model.Instructor;
import com.lotus.lotusSPM.service.base.CoordinatorService;
import com.lotus.lotusSPM.service.base.InstructorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CoordinatorController {

	@Autowired
	private CoordinatorService coordinatorService;
	
	@Autowired
	private InstructorService instructorService;

	@GetMapping("/coordinators")
	public ResponseEntity<Object> getCoordinators() {
		List<Coordinator> coordinators = coordinatorService.findCoordinators();
		return ResponseEntity.ok(coordinators);
	}

	@GetMapping("/coordinator/{id}")
	public ResponseEntity<Object> getCoordinator(@PathVariable("id") Long id) {

		Coordinator coor = coordinatorService.findCoordinatorById(id);
		return ResponseEntity.ok(coor);

	}

	@DeleteMapping("/coordinator/{id}")
	public ResponseEntity<?> deleteCoordinator(@PathVariable("id") Long id) {

		coordinatorService.deleteCoordinator(id);
		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/coordinator")
	public ResponseEntity<URI> createCoordinator(@RequestBody Coordinator coor) {
		try {
			coordinatorService.createCoordinator(coor);
			Long id = coor.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/coordinator/login")
	public ResponseEntity<Object> login(@RequestBody Coordinator coordinator) {
		Coordinator login = coordinatorService.findByUsername(coordinator.getUsername());
		if (login.getPassword().equals(coordinator.getPassword()) == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/assignCoordinator")
	public ResponseEntity<URI> assingCoordinator(@RequestBody Coordinator coordinator) {
		try {
			Instructor ins = instructorService.findByUsername(coordinator.getUsername());
			coordinator.setDepartment(ins.getDepartment());
			coordinator.setEmail(ins.getEmail());
			coordinator.setFaculty(ins.getFaculty());
			coordinator.setName(ins.getName());
			coordinator.setSurname(ins.getSurname());
			coordinator.setUsername(ins.getUsername());
			coordinator.setId(ins.getId());
			coordinatorService.save(coordinator);
			Long id = ins.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
