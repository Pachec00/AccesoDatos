package Ejercicio6.xml;

import java.util.List;

import javax.xml.transform.TransformerException;

import Ejercicio6.xml.xmlService;
import Ejercicio6.modelo.Pelicula;

public class App {

	public static void main(String[] args) {
		Pelicula pelicula = new Pelicula();
		
		List<Pelicula> p = pelicula.createRandomList(5);
		
		String ruta = "C:\\Users\\frodriguez0023\\Desktop\\Fichero\\ejercicio6_6.xml";
		xmlService xml = new xmlService();
		
		try {
			xml.crearXML(p, ruta);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
