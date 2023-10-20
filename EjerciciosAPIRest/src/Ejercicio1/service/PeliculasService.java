package Ejercicio1.service;

import java.util.ArrayList;
import java.util.List;	

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ejercicio1.modelo.Pelicula;

@RestController
public class PeliculasService {

	
	@GetMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam Integer longitud) {
		PeliculasServices ps = new PeliculasServices();
		List<Pelicula> peliculas = new ArrayList<>();
		
		try {
			peliculas = ps.consultarPeliculas(longitud);
		} catch (PeliculasServiceException e) {
			
		}
		
		return peliculas;
		
		
		
	}
}
