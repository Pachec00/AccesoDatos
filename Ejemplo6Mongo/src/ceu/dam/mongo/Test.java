package ceu.dam.mongo;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {

	public static void main(String[] args) {
		MongoDatabase db = MongoSession.getDatabase();
		
		MongoCollection<Document> c = db.getCollection("personas");
		
		Document document = new Document();
		document.append("dni", "777777");
		document.append("nombre", "Fabio");
		document.append("apellidos", "Rodriguez");
		document.append("edad", 20);
		
		c.insertOne(document);
	}
}
