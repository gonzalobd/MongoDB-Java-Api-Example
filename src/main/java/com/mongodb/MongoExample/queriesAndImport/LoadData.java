package com.mongodb.MongoExample.queriesAndImport;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sun.misc.ClassLoaderUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Gonzalo Bautista
 */
public class LoadData {

    public static void load(Logger log){

        MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase db = client.getDatabase("test");

        try{
            log.info("Creating Database...");
            db.createCollection("air");
        } catch (Exception e){
            log.info("Database is Already Created!");
        }

        MongoCollection<Document> collection = db.getCollection("air");
        InputStream inputStream = ClassLoaderUtil.class.getResourceAsStream("/air.json");

        String line;

        try {
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(streamReader);
            try {
                while((line = br.readLine()) != null){
                    Document doc=Document.parse(line);
                    collection.insertOne(doc);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
