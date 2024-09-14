package com.lotus.lotusSPM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notifications {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String from;
	private String to;
	private String date;
	private String time;
	private String title;
	private String text;
	//özel classlar kulan dual
	
	public Notifications() {

	}

	public Notifications(Long id, String from, String to, String date, String time, String title, String text) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.title = title;
		this.text = text;
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "FROM")
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "TO")
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "DATE")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "TIME")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
