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

import com.lotus.lotusSPM.model.Admin;
import com.lotus.lotusSPM.model.CareerCenter;
import com.lotus.lotusSPM.service.base.CareerCenterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CareerCenterController {

	@Autowired
	private CareerCenterService careerCenterService;

	@GetMapping("/careerCenters")
	public ResponseEntity<Object> getCareerCenter() {
		List<CareerCenter> careerCenter = careerCenterService.findCareerCenters();
		return ResponseEntity.ok(careerCenter);
	}

	@GetMapping("/careerCenter/{id}")
	public ResponseEntity<Object> getcareerCenter(@PathVariable("id") Long id) {
		CareerCenter careerCenter = careerCenterService.findCareerCenterById(id);
		return ResponseEntity.ok(careerCenter);

	}

	@DeleteMapping("/careerCenter/{id}")
	public ResponseEntity<?> deleteCareerCenter(@PathVariable("id") Long id) {

		careerCenterService.deleteCareerCenter(id);
		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/assingCareerCenter")
	public ResponseEntity<URI> createCareerCenter(@RequestBody CareerCenter careerCenter) {
		try {
			careerCenterService.createCareerCenter(careerCenter);
			Long id = careerCenter.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/careerCenter/login")
	public ResponseEntity<Object> login(@RequestBody CareerCenter careerCenter) {
		CareerCenter login = careerCenterService.findByUsername(careerCenter.getUsername());
		if (login.getPassword().equals(careerCenter.getPassword()) == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
