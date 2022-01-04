package com.example.model;

import java.io.Serializable;
/**
 * @author Sujit_Sahoo
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 3711318271951360456L;
	
	private String id;
	private String name;
	private Address address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
