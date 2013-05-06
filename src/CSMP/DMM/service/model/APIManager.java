package CSMP.DMM.service.model;


import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
//要連結到mongodb的所有api都透過這個APIManager來控制
public enum APIManager implements CSMP_DMM_API {

	INSTANCE;
	private  MongoClient mongoclient;

	//private static MongoClient mongoclient;
	public DBCollection getInstance(int service_type, String collectionName) throws Exception {
		if (service_type == backup_opportunities_v1) {
			return getConnection(collectionName);
		}
		else if (service_type == backup_campaigns_v1) {
			return getConnection(collectionName);
		}
		else {
			throw new IllegalArgumentException("Service for id " + service_type
					+ " not found...");
		}
		
	}
	
	private DBCollection getConnection(String collectionName) {
			try {
				mongoclient = MongoFactory.getInstanceOfMongo();
				DB db = mongoclient.getDB("CSS");
				DBCollection collection = db.getCollection(collectionName);			
				
				return collection;
		
			} catch (MongoException e) {  
	            e.printStackTrace();  
	        } finally{
	        	
	        }
			
		return null;
	}
}