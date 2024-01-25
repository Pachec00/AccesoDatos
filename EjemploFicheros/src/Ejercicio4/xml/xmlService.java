package Ejercicio4.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Ejercicio4.modelo.Edicion;
import Ejercicio4.modelo.Libro;

public class xmlService {

	public void crearXML(List<Libro> libros, String ruta) throws TransformerException {

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element root = xml.createElement("libros");
			xml.appendChild(root);

			for (Libro libro : libros) {
				Element libroTag = xml.createElement("libro");
				root.appendChild(libroTag);
				libroTag.setAttribute("isbn", libro.getIsbn().toString());

				Element tituloTag = xml.createElement("titulo");
				libroTag.appendChild(tituloTag);
				tituloTag.setTextContent(libro.getTitulo());

				Element autoresTag = xml.createElement("autores");
				libroTag.appendChild(autoresTag);

				for (String libro1 : libro.getAutores()) {
					Element autorTag = xml.createElement("autor");
					autoresTag.appendChild(autorTag);
					autorTag.setTextContent(libro1);
				}

				Element edicionesTag = xml.createElement("ediciones");
				libroTag.appendChild(edicionesTag);

				

				for (Edicion edicion : libro.getEdiciones()) {
					Element edicionTag = xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);
					
					Element añoTag = xml.createElement("año");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getAño().toString());

					Element editorialTag = xml.createElement("editorial");
					edicionTag.appendChild(editorialTag);
					editorialTag.setTextContent(edicion.getEditorial());
				}

			}

			// Guardar XML en fichero
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(ruta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
