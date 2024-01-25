package Ejercicio1.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Ejercicio1.modelo.Pelicula;
import Ejercicio1.service.PeliculasServiceException;
import Ejercicio1.service.PeliculasServices;

public class csvService {

	public void escribirPeliculas(String ruta) throws PeliculasServiceException {
		PeliculasServices s = new PeliculasServices();
		List<Pelicula> lista = s.consultarPeliculas(100);
		
		File file = new File(ruta);
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file);
			for(Pelicula p: lista) {
				writer.write(p.toCsv()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (Exception e2) {
			}
		}
	}
}
