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
import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admins")
	public ResponseEntity<Object> getAdmins() {
		List<Admin> admins = adminService.findAdmins();
		return ResponseEntity.ok(admins);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<Object> getAdmin(@PathVariable("id") Long id) {

		Admin admin = adminService.findAdminById(id);
		return ResponseEntity.ok(admin);

	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") Long id) {
		adminService.deleteAdmin(id);
		return ResponseEntity.ok().build();

	}
	
	@PostMapping("/admin")
	public ResponseEntity<URI> createAdmin(@RequestBody Admin admin) {
		try {
			adminService.createAdmin(admin);
			Long id = admin.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/admin/login")
	public ResponseEntity<Object> login(@RequestBody Admin admin) {
		Admin login = adminService.findByUsername(admin.getUsername());
		if (login.getPassword().equals(admin.getPassword()) == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

}
