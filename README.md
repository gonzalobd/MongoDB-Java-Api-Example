# MongoDBJavaApiExample
A brief example using the Java Api of MongoDB. Using code in Java is a good way to automatize C.R.U.D. operations.

In this example we will load data about air quality stations in a json file in resources folder. Then we will run two queries:

  - The number of measurements of one component (O3) in Argentina between 10 and 15 mg/Nm3
  - The total number of entries of Spain and Italy in the dataset.

# Requisites
Install your MongoDb in your linux/ubuntu system following the guide in:
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
Then initialize your mongod service:

         > $ sudo service mongod start

## Or, if you have Docker installed:

A smart and clean way of work is using Docker containers. You can get rid of installing mongo just running an Mongo Docker Container

         > $ docker run  --net host  --name some-mongo -d mongo

# Running.

Just run the .jar, or the main class Mongo.java in your favourite IDE.
