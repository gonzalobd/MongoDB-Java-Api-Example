# MongoDBJavaApiExample
A brief example using the Java Api of MongoDB. Using code in Java is a good way to automatize C.R.U.D. operations.

In this example we will load data about air quality stations in a json file in "MongoDBJavaApiExample/src/main/java/com/mongodb/test/MongoExample/data". Then we will run two queries:

  - The number of measurements of one component (O3) in Argentina between 10 and 15 mg/Nm3
  - The total number of entries of Spain and Italy in the dataset.

# Requisites
Install your MongoDb in your linux/ubuntu system following the guide in:
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
Then initialize your mongod service:

         > sudo service mongod start

# Running.

Just run the main class Mongo.java in your favourite IDE.
