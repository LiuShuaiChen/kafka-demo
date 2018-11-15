package com.alice.entity;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -626645091957590311L;
	private int Id;
	private String name;
	private int age;
	private String address;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
