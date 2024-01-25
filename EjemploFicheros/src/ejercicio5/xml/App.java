package ejercicio5.xml;

import java.util.List;

import javax.xml.transform.TransformerException;

import xml.xmlSimple;

public interface App {

	public static void main(String[] args) {

		

		testLeerXML();
	}
	
	private static void testLeerXML() {
		xmlService xml = new xmlService();
		
		xml.leerXML("C:\\Users\\frodriguez0023\\Desktop\\Fichero\\ejemplo.xml");
		
		
	}

}
