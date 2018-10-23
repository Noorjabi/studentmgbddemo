package com.decipherzone.studentmgnt.config;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


import java.util.Arrays;

public class JavaMongoDbConnection {
    /**
     * purpose :create connection
     * @return mongoclient instance
     */
    public MongoClient mongoDbConnection(){

        MongoCredential credential;
        credential = MongoCredential.createCredential("admin", "admin",
                "admin123".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017),
                Arrays.asList(credential));
        System.out.println("Connected to the database successfully");

        return mongoClient;


    }
}
