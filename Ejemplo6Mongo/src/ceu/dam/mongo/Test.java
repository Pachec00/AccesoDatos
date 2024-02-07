package ceu.dam.mongo;

import java.util.ArrayList;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.modelo.Direccion;
import ceu.dam.modelo.Persona;
import ceu.dam.service.PersonaService;

public class Test {

	public static void main(String[] args) {
//		System.out.println("Intentando iniciar conexión...");
//		MongoDatabase db = MongoSession.getDatabase();
//		System.out.println("Conexión establecida");
//
//		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);

		Persona p = new Persona("23423X", "María de las Nieves", 48);
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Avda Hola", "Sevilla", 41002));
		p.getDirecciones().add(new Direccion("Avda Playa, 3", "Málaga", 23002));
		p.getDirecciones().add(new Direccion("Avda Montaña, 23", "Granada", 12002));

//		InsertOneResult result = c.insertOne(p);
//		System.out.println(result.getInsertedId());
//		System.out.println("OK!!");
		
		PersonaService s = new PersonaService();
		
		String id = s.insertarPersona(p);
		System.out.println(id);

	}
}
