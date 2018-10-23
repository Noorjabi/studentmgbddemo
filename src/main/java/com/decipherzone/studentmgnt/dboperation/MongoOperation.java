package com.decipherzone.studentmgnt.dboperation;

import com.decipherzone.studentmgnt.config.JavaMongoDbConnection;
import com.decipherzone.studentmgnt.entity.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Iterator;

public class MongoOperation {
    private JavaMongoDbConnection javaMongoDbConnection;
    private MongoClient mongoClient;

    public MongoOperation() {
        this.javaMongoDbConnection = new JavaMongoDbConnection();
        this.mongoClient = javaMongoDbConnection.mongoDbConnection();
    }

    /**
     * purpose: adding student into database
     *
     * @param student
     * @param
     */

    public void addStudentDb(Student student) {


        MongoDatabase database = mongoClient.getDatabase("admin");

        //
        MongoCollection<Document> collection = database.getCollection("studentCollection");
        System.out.println("Collection studentCollection selected successfully");


        Document document = new Document("id", student.getId());
        document.put("Name", student.getStdname());
        document.put("age", student.getAge());
        collection.insertOne(document);
        System.out.println("Document inserted successfully");


    }

    /**
     * purpose:Delete student from database
     *
     * @param id implementation:
     *           Accessing the database
     *           Retrieving a collection
     *           Deleting the documents
     *           Retrieving the documents after updation
     *           Getting the iterable object
     *           Getting the iterator
     */
    public void deleteStudentDb(int id) {


        MongoDatabase database = mongoClient.getDatabase("admin");


        MongoCollection<Document> collection = database.getCollection("studentCollection");
        System.out.println("Collection studentCollection selected successfully");
        long count = collection.count(Filters.eq("id", id));
        if (count == 0) {
            System.out.println("\nId does'nt match\n");
        } else {
            collection.deleteMany(Filters.eq("id", id));
            System.out.println("Document deleted successfully...");
        }
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;

        //
        Iterator iterator = iterDoc.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
            i++;
        }


    }

    /**
     * purpose:retrieve student from database
     * implementation:
     * Accessing the database
     * Retrieving a collection
     * Getting the iterable object
     * Getting the iterator
     */
    public void retrieveStudentDb() {


        MongoDatabase database = mongoClient.getDatabase("admin");


        MongoCollection<Document> collection = database.getCollection("studentCollection");
        System.out.println("Collection studentCollection selected successfully");
        long count = collection.count();
        if (count == 0) {
            System.out.println("\nData is not exist\n");
        }

        FindIterable<Document> itereratorDocument = collection.find();
        int i = 1;


        Iterator iterator = itereratorDocument.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            i++;
        }


    }

    /**
     * purpose:update student into database
     *
     * @param id implementation:
     *           Accessing the database
     *           Retrieving a collection
     *           Retrieving the documents after updation
     *           Getting the iterable object
     *           Getting the iterator
     */
    public void updateStudentDb(int id, Student student) {


        MongoDatabase database = mongoClient.getDatabase("admin");


        MongoCollection<Document> collection = database.getCollection("studentCollection");
        System.out.println("Collection studentCollection selected successfully");
        long count = collection.count(Filters.eq("id", id));
        if (count == 0) {
            System.out.println("\nId does'nt match\n");
        } else {

            collection.updateOne(Filters.eq("id", id), Updates.set("Name", student.getStdname()));
            collection.updateOne(Filters.eq("id", id), Updates.set("age", student.getAge()));
            System.out.println("Document update successfully...");
        }
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;


        Iterator iterator = iterDoc.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            i++;
        }

    }
}
