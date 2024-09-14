package com.lotus.lotusSPM.service.base;

import java.util.List;
import java.util.Optional;

import com.lotus.lotusSPM.model.Student;

public interface StudentService {

	Student findByUsername(String username);
	List<Student> findStudents();
	Student findStdById(Long id);
	Student createStudent(Student student);
	void deleteStudent(Long id);

}
