package xml;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class App {
	public static void main(String[] args) {
		//testCrearXML();
		
		testLeerXML();
		
		
	}

	private static void testLeerXML() {
		xmlSimple xml = new xmlSimple();
		
		xml.leerXML("C:\\Users\\frodriguez0023\\Desktop\\Fichero\\ejemplo.xml");
		
		
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
