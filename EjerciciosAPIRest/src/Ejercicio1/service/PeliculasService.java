package Ejercicio1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import Ejercicio1.modelo.Pelicula;

@RestController
public class PeliculasService {

	@GetMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam Integer longitud) throws HttpStatusCodeException, PeliculasServiceException {
		PeliculasServices ps = new PeliculasServices();
		List<Pelicula> peliculas = new ArrayList<>();

		peliculas = ps.consultarPeliculas(longitud);
		for (Iterator iterator = peliculas.iterator(); iterator.hasNext();) {
			Pelicula pelicula = (Pelicula) iterator.next();
			if (pelicula.getLongitud() < 20 || pelicula.getLongitud() > 300) {
				
			}

		}

		return peliculas;

	}
}
