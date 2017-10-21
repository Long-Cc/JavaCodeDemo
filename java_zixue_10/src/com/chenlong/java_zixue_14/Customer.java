package com.chenlong.java_zixue_14;

public class Customer {
	private String name;
	private Integer id;
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + "]";
	}
	public Customer(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
