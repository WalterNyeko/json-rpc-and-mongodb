package com.json.rpc.jsonrpc.service;

import java.util.List;

import com.json.rpc.jsonrpc.model.Person;

public interface PersonService {

	Person addPerson(Person person);
	Person getPersonByFirstName(String firstName);
	Person getPersonByLastName(String lastName);
	List<Person> getEveryBody();
	void deleteSomeone(String firstName);
}
