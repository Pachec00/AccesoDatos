package ceu.dam.service;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.modelo.Direccion;
import ceu.dam.modelo.Persona;
import ceu.dam.mongo.MongoSession;

public class PersonaService {

	public String insertarPersona(Persona persona) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);

		Persona p = new Persona("23423X", "María de las Nieves", 48);
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Avda Hola", "Sevilla", 41002));
		p.getDirecciones().add(new Direccion("Avda Playa, 3", "Málaga", 23002));
		p.getDirecciones().add(new Direccion("Avda Montaña, 23", "Granada", 12002));

		InsertOneResult result = c.insertOne(p);
		return result.getInsertedId().toString();
	}
	
	public Persona consultarPersona(String id) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		
		Filters.eq("_id",id);
		FindIterable<Persona> result = c.find();
		
		
		Persona perona = new Persona();
		
		return perona;
	}
	
	public List<Persona> consultarTodasPersona(String id) {
		List<Persona> p = new ArrayList<Persona>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		
		FindIterable<Persona> result = c.find();
		MongoCursor<Persona> cursor = result.cursor();
		
		while(cursor.hasNext()) {
			p.add(cursor.next());
		}
		
		return p;
	}
}
