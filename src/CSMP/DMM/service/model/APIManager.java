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
//要連結到mongodb的所有api都透過這個APIManager來控制
public enum APIManager implements CSMP_DMM_API {

	INSTANCE;

	public DBCollection getInstance(int service_type, String collectionName) throws Exception {
		if (service_type == insert_opportunities) {
			return getOpportunitiesConnection(collectionName);
		} else {
			throw new IllegalArgumentException("Service for id " + service_type
					+ " not found...");
		}
	}
	
	private DBCollection getOpportunitiesConnection(String collectionName) {
			try {
				Mongo mongo = new Mongo("192.168.1.237", 27017);
				DB db = mongo.getDB("CSS");
				DBCollection collection = db.getCollection(collectionName);				
				return collection;
			} catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (MongoException e) {  
	            e.printStackTrace();  
	        }  
		return null;
	}
}