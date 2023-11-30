package prueba.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prueba.modelo.Actor;

@RestController
public class ActorService {

	/*
	 * getNombre
	 * getActor
	 * getActorById
	 */
	
	@GetMapping("/nombre")
	public Actor getNombre (@RequestParam String nombre) throws DeporteNotFoundException {
		Actor actor = new Actor();
		actor.setFirstName(nombre);
		
		if(nombre.equals(null)) {
			throw new DeporteNotFoundException("No existe ese nombre");
		}
		actor.setFirstName(nombre);
		return actor;
		
	}
}
