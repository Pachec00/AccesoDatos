package SAX.ejemplo1;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Ejemplo1.modelo.Curso;

public class XMLCursosServices {

	public List<Curso> leerCursos(String filePath) {

		XMLCurosHandler handler = new XMLCurosHandler();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			
			
			File file = new File(filePath);
			
			parser.parse(file,handler);
			
			return handler.getCursos();
		} catch (Exception e) {
			System.err.println("Error leyendo XML : " + e.getMessage());
			return null;
		}
		

	}
}
