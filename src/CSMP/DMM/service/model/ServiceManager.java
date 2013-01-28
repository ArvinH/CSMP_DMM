package CSMP.DMM.service.model;

import java.io.IOException;
import java.net.UnknownHostException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public enum ServiceManager implements CloudFoundryServices {

	INSTANCE;
	private static final String NULL_STRING = "";

	public DBCollection getInstance(int service_type) throws Exception {
		if (service_type == Mongodb) {
			return getMongoDBConnection();
		} else {
			throw new IllegalArgumentException("Service for id " + service_type
					+ " not found...");
		}
	}
	
	private DBCollection getMongoDBConnection() {
		
			
		System.setProperty("java.net.preferIPv4Stack", "true");
	
			try {
				Mongo mongo = new Mongo("192.168.1.237", 27017);
				//CommandResult auth = mongo.getDB("db").authenticateCommand("0601dda9-7df4-49ea-a91c-6a38dcdbd07e", "25775550-da73-4d1c-be30-6b99eeb1be96".toCharArray());
				//System.out.println(auth);
				DB db = mongo.getDB("CSS");
				DBCollection collection = db.getCollection("CSMP_DMM");
				
				
				return collection;
			} catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (MongoException e) {  
	            e.printStackTrace();  
	        }  
		
		return null;
	}
}