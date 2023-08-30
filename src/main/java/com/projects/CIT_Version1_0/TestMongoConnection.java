package com.projects.CIT_Version1_0;


import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongoConnection {

	public static void main(String[] args) {
		String uri = "mongodb+srv://avravrakesh:Rakcare08#@cluster0.q5w8d8x.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("CIT");
            MongoCollection<org.bson.Document> collection = database.getCollection("incident");
            Document doc = collection.find().first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }

	}

}
