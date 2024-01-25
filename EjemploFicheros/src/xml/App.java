package xml;

import java.util.List;

import javax.xml.transform.TransformerException;

import SAX.ejercicio8.LibroException;
import SAX.ejercicio8.XMLLibroServices;
import SAX.ejercicio8.modelo.Libro;

public class App {
	public static void main(String[] args) {
		// testCrearXML();

		testLeerXML();

	}

	private static void testLeerXML() {
		XMLLibroServices service = new XMLLibroServices();

		List<Libro> libros;
		try {
			libros = service.leerLibro("C:\\Users\\frodriguez0023\\Desktop\\Fichero\\xmlLibros.xml");
			for (int i = 0; i < libros.size(); i++) {
				System.out.println(libros.get(i));
			}
		} catch (LibroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void testCrearXML() {
		xmlSimple xml = new xmlSimple();

		try {
			xml.crearXML("C:\\Users\\frodriguez0023\\Desktop\\Fichero");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
