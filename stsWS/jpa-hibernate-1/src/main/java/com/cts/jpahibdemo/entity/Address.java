package com.cts.jpahibdemo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String doornum;
	private String city;
	private String state;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String doornum, String city, String state) {
		super();
		this.doornum = doornum;
		this.city = city;
		this.state = state;
	}

	public String getDoornum() {
		return doornum;
	}

	public void setDoornum(String doornum) {
		this.doornum = doornum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [doornum=" + doornum + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
