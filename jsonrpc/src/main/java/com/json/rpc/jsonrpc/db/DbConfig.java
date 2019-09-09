package com.json.rpc.jsonrpc.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DbConfig {
	
	@SuppressWarnings({ "deprecation", "resource" })
	public static DB getDatabaseConnection() {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		DB database = mongoClient.getDB("alation");
		
		return database;
	}

}
