package com.vxpx.shouldgo.mongo;

package com.demo.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class TestDB {
public static void main(String[] args) {
try {
/**** Connect to MongoDB ****/
// Since 2.10.0, uses MongoClient
MongoClient mongoClient = new MongoClient("localhost", 27017);
/**** Get database ****/
// if database doesn't exists, MongoDB will create it for you
DB db = mongoClient.getDB("testdb");
mongoClient.getDatabaseNames().forEach(System.out::println);
/**** Get collection / table from 'testdb' ****/
// if collection doesn't exists, MongoDB will create it for you
DBCollection collection = db.getCollection("users");
/**** Insert ****/
// create a document to store key and value
BasicDBObject document = new BasicDBObject();
document.put("firstName", "Dharam");
document.put("lastName", "Rajput");
collection.insert(document);
/**** Find and display ****/
BasicDBObject searchQuery = new BasicDBObject();
searchQuery.put("firstName", "Dharam");
DBCursor dbCursor = collection.find(searchQuery);
while (dbCursor.hasNext()) {
System.out.println(dbCursor.next());
}
/**** Update ****/
// search document where name="Dharam" and update it with new values "Dharmendra"
BasicDBObject dbQuery = new BasicDBObject();
dbQuery.put("firstName", "Dharam");
BasicDBObject newDocument = new BasicDBObject();
newDocument.put("firstName", "Dharmendra");
BasicDBObject updateObj = new BasicDBObject();
updateObj.put("$set", newDocument);
collection.update(dbQuery, updateObj);
/**** Find and display ****/
BasicDBObject findQuery
&nbsp;&nbsp;&nbsp;= new BasicDBObject().append("firstName", "Dharmendra");
DBCursor findCursor = collection.find(findQuery);
while (findCursor.hasNext()) {
System.out.println(findCursor.next());
}
&nbsp;&nbsp;&nbsp;} catch (Exception e) {
e.printStackTrace();
&nbsp;}
}
}
