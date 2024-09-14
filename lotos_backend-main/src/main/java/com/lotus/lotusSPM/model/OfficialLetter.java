package com.lotus.lotusSPM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "OFFICIAL_LETTER")
public class OfficialLetter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String uuid;
	private Long id;
	private String username;
	private String date;
	private String comName;
	@Lob
	private byte[] pdf;
	private String name;
	private String type;

	
	public OfficialLetter() {
	}

	
	public OfficialLetter(String uuid, Long id, String username, String date, String comName, byte[] pdf, String name,
			String type) {
		super();
		this.uuid = uuid;
		this.id = id;
		this.username = username;
		this.date = date;
		this.comName = comName;
		this.pdf = pdf;
		this.name = name;
		this.type = type;
	}


	public OfficialLetter(byte[] pdf, String name, String type) {
		super();
		this.pdf = pdf;
		this.name = name;
		this.type = type;
	}

	
	
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Column(name = "DATE")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "COMPANY_NAME")
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	@Column(name = "PDF")
	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
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

	
}
