package Ejercicio6.xml;

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

import Ejercicio6.modelo.Pelicula;
import Ejercicio6.modelo.Persona;

public class xmlService {

	public void crearXML(List<Pelicula> peliculas, String ruta) throws TransformerException {

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element root = xml.createElement("libros");
			xml.appendChild(root);

			for (Pelicula pelicula : peliculas) {
				Element peliculaTag = xml.createElement("pelicula");
				root.appendChild(peliculaTag);

				Element tituloTag = xml.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo());

				Element duracionTag = xml.createElement("duracion");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());

				Element añoTag = xml.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());

				Element artistasTag = xml.createElement("artistas");
				peliculaTag.appendChild(artistasTag);
				
				
				Element direccionTag = xml.createElement("artista");
				artistasTag.appendChild(direccionTag);
				direccionTag.setAttribute("tipo", Persona.DIRECCION);
				
				Element nombreDireccionTag = xml.createElement("nombre");
				direccionTag.appendChild(nombreDireccionTag);
				nombreDireccionTag.setTextContent(pelicula.getDireccion().getNombre());

				Element nacionalidadDireccionTag = xml.createElement("nacionalidad");
				direccionTag.appendChild(nacionalidadDireccionTag);
				nacionalidadDireccionTag.setTextContent(pelicula.getDireccion().getNacionalidad());

				Element produccionTag = xml.createElement("artista");
				artistasTag.appendChild(produccionTag);
				produccionTag.setAttribute("tipo", Persona.PRODUCCION);
				
				Element nombreProduccionTag = xml.createElement("nombre");
				produccionTag.appendChild(nombreProduccionTag);
				nombreProduccionTag.setTextContent(pelicula.getProduccion().getNombre());

				Element nacionalidadProduccionTag = xml.createElement("nacionalidad");
				produccionTag.appendChild(nacionalidadProduccionTag);
				nacionalidadProduccionTag.setTextContent(pelicula.getProduccion().getNacionalidad());

				for (Persona persona : pelicula.getActores()) {
					Element artistaTag = xml.createElement("artista");
					artistasTag.appendChild(artistaTag);
					artistaTag.setAttribute("tipo", Persona.INTERPRETACION);

					Element nombreTag = xml.createElement("nombre");
					artistaTag.appendChild(nombreTag);
					nombreTag.setTextContent(persona.getNombre());

					Element nacionalidadTag = xml.createElement("nacionalidad");
					artistaTag.appendChild(nacionalidadTag);
					nacionalidadTag.setTextContent(persona.getNacionalidad());
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
