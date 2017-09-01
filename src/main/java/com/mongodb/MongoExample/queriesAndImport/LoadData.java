package com.mongodb.MongoExample.queriesAndImport;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Gonzalo Bautista
 */
public class LoadData {

    public static void load(){
        MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase db = client.getDatabase("test");
        db.createCollection("air");
        MongoCollection<Document> collection = db.getCollection("air");
        FileReader fr = null;
        String line;

        try {
            //TODO: insert the path of the json file in your system (FileReader):
            fr = new FileReader("/home/hadoop/IdeaProjects/mongoDBEjercicio/MongoDBJavaApiExample/src/main/java/com/mongodb/test/MongoExample/data/air.json");
            BufferedReader br = new BufferedReader(fr);
            try {
                while((line = br.readLine()) != null){
                    Document doc=Document.parse(line);
                    collection.insertOne(doc);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
