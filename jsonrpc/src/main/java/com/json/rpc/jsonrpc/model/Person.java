package com.json.rpc.jsonrpc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)//This will remove all null fields from our final JSON objects
public class Person {
	private String firstName;
	private String lastName;
	private String alias;
	private boolean isMale;
	private int age;
	private Address address;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@JsonProperty("isMale")//This will force the name of the key to be isMale as opposed to male
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person(String firstName, String lastName, String alias, boolean isMale, int age, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.alias = alias;
		this.isMale = isMale;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", alias=" + alias + ", isMale=" + isMale
				+ ", age=" + age + "]";
	}

	
}
