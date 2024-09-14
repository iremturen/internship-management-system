package com.lotus.lotusSPM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "APPLICATION_FORM")
public class ApplicationForm {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String stu_id;

	private String name;

	private String type;

	@Lob
	private byte[] data;

	
	public ApplicationForm() {
	}


	public ApplicationForm(String id, String stu_id, String name, String type, byte[] data) {
		super();
		this.id = id;
		this.stu_id = stu_id;
		this.name = name;
		this.type = type;
		this.data = data;
	}


	public ApplicationForm(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "STUDENT_ID")
	public String getStu_id() {
		return stu_id;
	}


	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "DATA")
	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}

}
