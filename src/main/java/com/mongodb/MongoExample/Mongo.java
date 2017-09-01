/**
 * Code by Gonzalo Bautista Davila http://www.github.com/gonzalobd
 * */


package com.mongodb.MongoExample;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoExample.queriesAndImport.LoadData;
import org.apache.log4j.Logger;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.MongoExample.queriesAndImport.QueryHelper;

public class Mongo {
	
	final static Logger log = Logger.getLogger(Mongo.class);

	public static void main (String [] args){
		long t1,t2;
		t1 = System.currentTimeMillis();

		log.info("---MongoJavaApiExample----");
		String component = "o3";
		String station = "Argentina";
		double min = 10;
		double max = 15;
		log.info("Loading Data into Database");
		LoadData.load();
		log.info("Data imported");

		MongoCursor<Document> dataByComponentInRange = QueryHelper.findByComponentInRange(station, component, min, max);
		int counter = 0;
		while(dataByComponentInRange.hasNext()){
			dataByComponentInRange.next();
			counter++;
		}
		log.info("Number of measures of "+component+" between "+min+" and "+max+" in "+station+": " + counter);
		List<String> stations = new ArrayList<String>();
		counter=0;
		stations.add("Italy");
		stations.add("Spain");
		MongoCursor<Document> dataByStationList = QueryHelper.findByStationList(stations);
		while(dataByStationList.hasNext()){
			dataByStationList.next();
			counter++;
		}
		log.info("Number of Stations in Argentina and Spain: " + counter);

		t2 = System.currentTimeMillis();

		log.info("End of script. Time elapsed:  " + (t2-t1)/1000.0);

	}

}
