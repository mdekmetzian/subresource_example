package com.mike.models;


import org.codehaus.jackson.annotate.JsonProperty;

public class Pet {

	private int id, ownerId; 
	private String name;
	
	public Pet() {}
	public Pet(int id, int ownerId, String name) {
		this.id = id; 
		this.ownerId = ownerId; 
		this.name = name; 
	}
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("ownerId")
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}
