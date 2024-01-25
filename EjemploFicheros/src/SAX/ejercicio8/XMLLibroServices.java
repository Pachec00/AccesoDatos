package SAX.ejercicio8;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import SAX.ejercicio8.modelo.Libro;

public class XMLLibroServices {

	public List<Libro> leerLibro(String filePath) throws LibroException{
		XMLLibroHandler handler = new XMLLibroHandler();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			
			
			File file = new File(filePath);
			
			parser.parse(file,handler);
			
			return handler.getLibros();
		} catch (Exception e) {
			System.err.println("Error leyendo XML : " + e.getMessage());
			throw new LibroException(e);
		}
	}
}
