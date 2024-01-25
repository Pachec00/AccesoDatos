package xml;

import java.io.File;

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
import org.w3c.dom.NodeList;

public class xmlSimple {

	public void leerXML(String ruta) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.parse(new File(ruta));

			Element root = xml.getDocumentElement();

			NodeList listaCursosTag = root.getElementsByTagName("curso");

			for (int i = 0; i < listaCursosTag.getLength(); i++) {
				Element cursoTag = (Element) listaCursosTag.item(i);

				Element nombreTag = (Element) cursoTag.getElementsByTagName("nombre").item(0);
				String nombre = nombreTag.getTextContent();
				System.out.println("Nombre curso : " + nombre);

				Element horasTag = (Element) cursoTag.getElementsByTagName("horas").item(0);
				String horas = horasTag.getTextContent();
				System.out.println("Horas curso : " + horas);

				Element alumnosTag = (Element) cursoTag.getElementsByTagName("alumnos").item(0);
				NodeList listaAlumnoTag = alumnosTag.getElementsByTagName("alumno");

				for (int j = 0; j < listaAlumnoTag.getLength(); j++) {
					Element alumnoTag = (Element) listaAlumnoTag.item(j);
					String nombreAlumno = alumnoTag.getTextContent();
					System.out.println("\tNombre alumno : " + nombreAlumno);
//					String dni = alumnoTag.getAttribute("dni");
//					System.out.println("\tDni alumnos : " + dni);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearXML(String nombre) throws TransformerException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.newDocument();

			Element root = xml.createElement("cursos");
			xml.appendChild(root);

			Element cursoTag = xml.createElement("curso");
			root.appendChild(cursoTag);

			Element nombreTag = xml.createElement("nombre");
			cursoTag.appendChild(nombreTag);
			nombreTag.setTextContent("Programacion");

			Element horasTag = xml.createElement("horas");
			cursoTag.appendChild(horasTag);
			horasTag.setTextContent("8");

			Element alumnosTag = xml.createElement("alumnos");
			cursoTag.appendChild(alumnosTag);

			Element alumnoTag = xml.createElement("alumno");
			alumnosTag.appendChild(alumnoTag);
			alumnoTag.setTextContent("Fabio");

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(
					new File("C:\\Users\\frodriguez0023\\Desktop\\Fichero\\ejemplo.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
