package com.mongodb.MongoExample.queriesAndImport;

import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import com.mongodb.client.MongoCursor;

public class QueryHelper {

	public static MongoCursor<Document> findByComponentInRange(String station, String component, double min, double max){
		MongoClient client = new MongoClient("localhost",27017);
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("air");
		MongoCursor<Document> a =collection.
				aggregate(Arrays.asList(Aggregates.match(Filters.
						eq("station", station)), Aggregates.
						match(Filters.gt(component,min)),Aggregates.match(Filters.lt(component,max)))).iterator();
		return a;

	}
	
	public static MongoCursor<Document> findByStationList(List<String> stations){
		MongoClient client = new MongoClient("localhost",27017);
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("air");

		MongoCursor<Document> a =collection.
				aggregate(Arrays.asList(Aggregates.match(Filters.in("station",stations)))).iterator();
		return a;
	}
}
