package prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prueba.modelo.Persona;

@RestController
public class PersonaService {

	/*
	 * getPersona getNombre
	 */

	@GetMapping("persona")
	public Persona getPersona(@RequestParam Integer id) {
		List<Persona> lista = new ArrayList();

		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();

		p1.setId(1);
		p1.setNombre("p1");

		p2.setId(2);
		p2.setNombre("p2");

		p3.setId(3);
		p3.setNombre("p3");

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		Persona p = new Persona();
		
		for (Persona r : lista) {
			if(r.getId() == id) {
				p.setNombre(r.getNombre());
				p.setId(r.getId());
			}
		}
		
		return p;

		
	}
	
	@GetMapping("/saludo")
	public String saludo() {
		String a = "Hola";
		
		return a;
	}

	public Persona listaPersonas(Integer id) {
		List<Persona> lista = new ArrayList();

		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();

		p1.setId(1);
		p1.setNombre("p1");

		p2.setId(2);
		p2.setNombre("p2");

		p3.setId(3);
		p3.setNombre("p3");

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);

		for (Persona r : lista) {
			if (r.getId() == id) {

			}
		}

		return null;

	}

}
