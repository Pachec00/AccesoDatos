package ejercicio5.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class xmlService {

	public void leerXML(String ruta) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.parse(new File(ruta));

			Element root = xml.getDocumentElement();

			NodeList listaLibrosTag = root.getElementsByTagName("libros");

			for (int i = 0; i < listaLibrosTag.getLength(); i++) {
				Element tituloTag = (Element) listaLibrosTag.item(0);

				Element autoresTag = (Element) tituloTag.getElementsByTagName("autores").item(0);
				NodeList listaAutorTag = autoresTag.getElementsByTagName("autor");

				for (int j = 0; j < listaAutorTag.getLength(); j++) {
					Element autorTag = (Element) listaAutorTag.item(j);
					String autor = autorTag.getTextContent();
					System.out.println("\tNombre del autor : " + autor);
				}
				
				Element edicionesTag = (Element) tituloTag.getElementsByTagName("ediciones");
				NodeList listaEdicionTag = edicionesTag.getElementsByTagName("edicion");
				
				for(int x = 0; x < listaEdicionTag.getLength(); x++) {
					Element edicionTag = (Element) listaEdicionTag.item(x);
					String año = edicionesTag.getTextContent();
					System.out.println("\tAño : " + año);
					String editorial = edicionesTag.getTextContent();
					System.out.println("\nEditorial : " + editorial );
				}
				
				

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
