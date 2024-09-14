package com.lotus.lotusSPM.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lotus.lotusSPM.dao.StudentDao;
import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.StudentService;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student findByUsername(String stu_id) {
		return studentDao.findByUsername(stu_id);

	}


	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Student> findStudents() {
		return studentDao.findAll();
	}


	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student findStdById(Long id) {
		Optional<Student> student = studentDao.findById(id);
		return student.get();
	}


	@Override
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}


	@Override
	public void deleteStudent(Long id) {
		studentDao.deleteById(id);		
	}


	


	

	

}
