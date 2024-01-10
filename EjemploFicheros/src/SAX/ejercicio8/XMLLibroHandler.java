package SAX.ejercicio8;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import SAX.ejercicio8.modelo.Edicion;
import SAX.ejercicio8.modelo.Libro;

public class XMLLibroHandler extends DefaultHandler {

	private Boolean openTag;
	private String texto;

	private Libro libro;
	private List<Libro> libros;
	
	
	private Edicion edicion;

	public XMLLibroHandler() {
		openTag = false;
		texto = "";
		libros = new ArrayList<Libro>();
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";

		if (qName.equals("libro")) {
			libro = new Libro();
			libro.setAutores(new ArrayList<String>());
			libro.setEdiciones(new ArrayList<Edicion>());
			libros.add(libro);
			Integer isbn = Integer.parseInt(attributes.getValue("isbn"));
			libro.setIsbn(isbn);
		}else if (qName.equals("edicion")) {
			edicion = new Edicion();
			libro.getEdiciones().add(edicion);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("titulo")) {
			libro.setTitulo(texto);
		}else if (qName.equals("autor")) {
			libro.getAutores().add(texto);
		}else if (qName.equals("año")) {
			edicion.setAño(Integer.parseInt(texto));
		}else if(qName.equals("editorial")) {
			edicion.setEditorial(texto);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}
	
	public List<Libro> getLibros(){
		return libros;
	}

}
