package CSMP.DMM.service.model;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class MongoFactory {

	private static MongoFactory mongoFactory = new MongoFactory();
	private static MongoClient mongoclient;
	private MongoFactory() {
		try{
		 mongoclient = new MongoClient(Arrays.asList(
				   new ServerAddress("192.168.1.63", 27017),
				   new ServerAddress("192.168.1.64", 27017),
				   new ServerAddress("192.168.1.65", 27017)));
		} catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (MongoException e) {  
            e.printStackTrace();  
        }
	}

	public static MongoFactory getInstance() {
		return mongoFactory;
	}
	public static MongoClient getInstanceOfMongo() {
		return mongoclient;
	}
}
