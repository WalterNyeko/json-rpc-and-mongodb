package com.json.rpc.jsonrpc.serviceImpl;

import java.util.List;

import com.google.gson.Gson;
import com.json.rpc.jsonrpc.db.DbConfig;
import com.json.rpc.jsonrpc.model.Person;
import com.json.rpc.jsonrpc.service.PersonService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.util.JSON;

public class PersonServiceImpl implements PersonService {
	
	@SuppressWarnings("static-access")
	DB database = new DbConfig().getDatabaseConnection();

	public PersonServiceImpl() {
		database.createCollection("engineers", null);
	}

	public Person addPerson(Person person) {
		DBCollection collection= database.getCollection("engineers");
		System.out.println("Reaching here");
		
		database.createCollection("engineers", null);
		
		Person newPerson = new Person();
		
		newPerson.setFirstName(person.getFirstName());
		newPerson.setLastName(person.getLastName());
		newPerson.setAlias(person.getAlias());
		newPerson.setAge(person.getAge());
		newPerson.setAddress(person.getAddress());
		newPerson.setMale(person.isMale());
		
		//Converting a custom Class(Person) to BasicDBObject
		Gson gson = new Gson();
		BasicDBObject object = (BasicDBObject)JSON.parse(gson.toJson(newPerson));
		
		collection.insert(object);
		
		return newPerson;
	}

	public Person getPersonByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person getPersonByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> getEveryBody() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteSomeone(String firstName) {
		// TODO Auto-generated method stub

	}

}
