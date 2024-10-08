package prueba.service;

import java.util.ArrayList;
import java.util.List;

import prueba.modelo.Persona;

public class PersonaService {

	private List<Persona> listaPersonas;

	public PersonaService() {
		listaPersonas = new ArrayList<>();
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();

		p1.setId(1);
		p1.setNombre("p1");

		p2.setId(2);
		p2.setNombre("p2");

		p3.setId(3);
		p3.setNombre("p3");

		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		// this.listaPersonas = listaPersonas;
	}

	public Persona getData(Integer id) {

		for (Persona r : listaPersonas) {
			if (r.getId() == id) {
				return r;
			}
		}

		return null;
	}

	public void setData(String nombre) {

		/*
		 * Saber cual es el id mas alto para asi incrementarlo en +1 al crear un nuevo
		 * objeto persona
		 */
		Integer max = 0;

		for (Persona p : listaPersonas) {
			if (p.getId() > max) {
				max = p.getId();
			}
		}

		Persona persona = new Persona();
		persona.setId(max);

		listaPersonas.add(persona);
	}
}
