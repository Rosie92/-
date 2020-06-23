package wc.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConn {

	private MongoDatabase database;
	private MongoClient mongoClient;
	
	// MongoConn 객체 생성시, 자동으로 데이터베이스 접속하도록 설정
	public MongoConn() {
		mongoClient = MongoClients.create("mongodb://myUser:1234@192.168.136.130:27017/?authSource=MyDB");
		database = mongoClient.getDatabase("MyDB");
	}
	
	public MongoDatabase getDatabase() {
		return database;
	}
	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	
}
