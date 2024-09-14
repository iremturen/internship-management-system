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
@Table(name = "OPPORTUNITIES")
public class Opportunities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String username;
	private String text;
	@Lob
	private byte[] logo;

	private String url;
	private String location;
	private String title;
	private String companyName;
	private String deadline;

	public Opportunities() {

	}

	

	public Opportunities(String uuid, String username, String text, String logoType, byte[] logo, String url,
			String location, String title, String companyName, String deadline, Long id) {
		super();
	
		this.username = username;
		this.text = text;
	
		this.logo = logo;
		this.url = url;
		this.location = location;
		this.title = title;
		this.companyName = companyName;
		this.deadline = deadline;
		this.id = id;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long opp_id) {
		this.id = opp_id;
	}

	

	@Column(name = "URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "DEADLINE")
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Column(name = "LOGO")
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Column(name = "TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
