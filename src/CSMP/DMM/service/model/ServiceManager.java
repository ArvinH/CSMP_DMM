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
		
		String vcap_services = System.getenv("VCAP_SERVICES");
		//String vcap_services = null;
		String host = NULL_STRING;
		String name = NULL_STRING;
		String username = NULL_STRING;
		String password = NULL_STRING;
		String port = NULL_STRING;
		
		System.setProperty("java.net.preferIPv4Stack", "true");
		if (vcap_services != null && vcap_services.length() > 0) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				JsonFactory factory = mapper.getJsonFactory();
				JsonParser jp;
				try {
					jp = factory.createJsonParser(vcap_services);
					JsonNode actualObj = mapper.readTree(jp);
					JsonNode credentials = actualObj.get("mongodb-1.8").get(0)
							.get("credentials");
					name = credentials.get("name").toString();
					host = credentials.get("host").toString();
					username = credentials.get("username").toString();
					password = credentials.get("password").toString();
					port = credentials.get("port").toString();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("name : " + name);
				System.out.println("host : " + host);
				System.out.println("port : " + port);
				System.out.println("username : " + username);
				System.out.println("password : " + password);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				Mongo mongo = new Mongo(host, Integer.parseInt(port));
				CommandResult auth = mongo.getDB("db").authenticateCommand(username, password.toCharArray());
				System.out.println(auth);
				DB db = mongo.getDB("db");
				//db.authenticate(username, password.toCharArray());
				DBCollection collection = db.getCollection("cloudfoundry");
				BasicDBObject doc = new BasicDBObject("name", "MongoDB")
						.append("type", "database")
						.append("count", 1)
						.append("info",
								new BasicDBObject("x", 201).append("y", 102));
				collection.insert(doc);
				DBObject myDoc = collection.findOne();
				System.out.println(myDoc);
				return collection;
			}  catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (MongoException e) {  
	            e.printStackTrace();  
	        }  
		} else {
			try {
				Mongo mongo = new Mongo("192.168.1.237", 27017);
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				//CommandResult auth = mongo.getDB("db").authenticateCommand("0601dda9-7df4-49ea-a91c-6a38dcdbd07e", "25775550-da73-4d1c-be30-6b99eeb1be96".toCharArray());
				//System.out.println(auth);
				DB db = mongo.getDB("test");
				DBCollection collection = db.getCollection("cloudfoundry");
				/*
				BasicDBObject doc = new BasicDBObject("name", "MongoDB")
						.append("type", "database")
						.append("count", 1)
						.append("info",
								new BasicDBObject("x", 203).append("y", 102));
				collection.insert(doc);
				DBObject myDoc = collection.findOne();
				System.out.println(myDoc); 
				*/ 
				return collection;
			} catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (MongoException e) {  
	            e.printStackTrace();  
	        }  
		}
		return null;
	}
}