package Ejercicio4.xml;

import java.util.List;

import javax.xml.transform.TransformerException;

import Ejercicio4.modelo.Libro;

public class App {

	public static void main(String[] args) {
		Libro libro = new Libro();
		
		List<Libro> l = libro.createRandomList(5);
		
		String ruta = "C:\\Users\\frodriguez0023\\Desktop\\Fichero\\ejercicio4_4.xml";
		xmlService xml = new xmlService();
		
		try {
			xml.crearXML(l, ruta);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
