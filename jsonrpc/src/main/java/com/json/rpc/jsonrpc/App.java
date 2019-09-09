package com.json.rpc.jsonrpc;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.json.rpc.jsonrpc.model.Address;
import com.json.rpc.jsonrpc.model.Person;
import com.json.rpc.jsonrpc.serviceImpl.PersonServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static PersonServiceImpl service = new PersonServiceImpl();
	
    public static void main( String[] args ) throws IOException
    {
    	
    	  serializations();  
    	  testCRUD();
        
        
    }
    
    public static void testCRUD() {
    	Address myAddress = new Address("Olia Road","Uganda","Kampala","256");
        Person myself = new Person("Walter", "Nyeko", "Nyeke", true, 23, myAddress);
        service.addPerson(myself);
        
    }
    
    public static void serializations() throws IOException {
    	/**
    	 * Serializing Java Objects to JSON using Jackson's library
    	 */
        Address myAddress = new Address("Olia Road","Uganda","Kampala","256");
        Person myself = new Person("Walter", "Nyeko", "Nyeke", true, 23, myAddress);
        
        System.out.println(myself);//Before converting to JSON
        
        /**
         * Using Jackson Databind to convert to JSON
         */
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(myself);
        
        System.out.println(json);//After converting to JSON
        
    
        /**
         * Deserializing JSON to Java Objects
         */
        
        Person meMyself = mapper.readValue(json, Person.class);
        System.out.println(meMyself);
        
        /**
         * Serialization using Google Gson
         */
     // Serialization
        Gson gson = new Gson();
        String gsonJSON = gson.toJson(myself); 
        System.out.println(gsonJSON);
        

        /**
         * Deserializing JSON to Java Objects Using Gson
         */
     // Deserialization
        Person gsonMyself = gson.fromJson(gsonJSON, Person.class);
        System.out.println(gsonMyself);
    }
    
}
