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

import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
//@RequestMapping("/student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student/{username}")
	public ResponseEntity<Object> getStudent(@PathVariable("username") String username) {
		try {
			Student student = studentService.findByUsername(username);
			return ResponseEntity.ok(student);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/students")
	public ResponseEntity<Object> getStudent() {
		List<Student> stocks = studentService.findStudents();
		return ResponseEntity.ok(stocks);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {

		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();

	}

	@PostMapping("/student")
	public ResponseEntity<URI> createStudent(@RequestBody Student student) {
		try {
			studentService.createStudent(student);
			Long id = student.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/student/login")
	public ResponseEntity<Object> login(@RequestBody Student student) {
		Student login = studentService.findByUsername(student.getUsername());
		if (login.getPassword().equals(student.getPassword()) == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
