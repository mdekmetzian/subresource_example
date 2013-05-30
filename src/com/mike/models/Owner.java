package com.mike.models;

import org.codehaus.jackson.annotate.JsonProperty;

public class Owner {
	private int id; 
	private String name;
	
	public Owner() { }
	public Owner(int id, String name) {
		this.id = id; 
		this.name = name; 
	}
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
