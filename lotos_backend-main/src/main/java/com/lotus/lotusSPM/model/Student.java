package com.lotus.lotusSPM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String internshipStatus;
	private String faculty;
	private String department;
	@Lob
	private byte[] transcript;

	

	public Student(Long id, String username, String password, String name, String surname, String email,
			String internshipStatus, String faculty, String department, byte[] transcript) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.internshipStatus = internshipStatus;
		this.faculty = faculty;
		this.department = department;
		this.transcript = transcript;
	}

	public Student() {

	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "INT_STATUS")
	public String getInternshipStatus() {
		return internshipStatus;
	}

	public void setInternshipStatus(String internshipStatus) {
		this.internshipStatus = internshipStatus;
	}

	@Column(name = "FACULTY")
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Column(name = "DEPARTMENT")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "TRANSCRIPT")
	public byte[] getTranscript() {
		return transcript;
	}

	public void setTranscript(byte[] transcript) {
		this.transcript = transcript;
	}

}
