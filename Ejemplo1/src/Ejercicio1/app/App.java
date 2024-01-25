package Ejercicio1.app;

import java.util.List;

import Ejercicio1.modelo.Pelicula;
import Ejercicio1.service.PeliculasServiceException;
import Ejercicio1.service.PeliculasServices;

public class App {

	public static void main(String[] args) {
		PeliculasServices service = new PeliculasServices();
		List<Pelicula> peliculas;
		try {
			peliculas = service.consultarPeliculas();
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}

	}

}
