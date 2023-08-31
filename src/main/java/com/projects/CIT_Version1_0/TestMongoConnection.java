package com.projects.CIT_Version1_0;


import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;

public class TestMongoConnection {

	public static void main(String[] args) {
		String uri = "mongodb+srv://avravrakesh:Rakcare08#@cluster0.q5w8d8x.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("CIT");
            MongoCollection<org.bson.Document> collection = database.getCollection("userProfile");
            Document doc = collection.find().first();
            try {
            	 Document index = new Document("userId", 1);
            	 collection.createIndex(index, new IndexOptions().unique(true));
                String resultCreateIndex = collection.createIndex(index);
                System.out.println(String.format("Index created: %s", resultCreateIndex));
            } catch (DuplicateKeyException e) {
                System.out.printf("duplicate field values encountered, couldn't create index: \t%s\n", e);
            }
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }

	}

}
