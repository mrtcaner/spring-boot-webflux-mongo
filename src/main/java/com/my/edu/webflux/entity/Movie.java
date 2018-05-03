package com.my.edu.webflux.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

	public Movie(){

	}

	public Movie(String title, String id) {
		this.title = title;
		this.id = id;
	}

	private String title;


	private String id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString(){
		return "id:" + id + ",title:" + title;
	}
}
