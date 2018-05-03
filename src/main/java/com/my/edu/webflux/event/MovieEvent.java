package com.my.edu.webflux.event;

import java.util.Date;


public class MovieEvent {

	private String id;
	private Date date;

	public MovieEvent() {
	}

	public MovieEvent(String id, Date date) {
		this.id = id;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
