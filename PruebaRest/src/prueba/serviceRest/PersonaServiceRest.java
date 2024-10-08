package prueba.serviceRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prueba.modelo.Persona;
import prueba.service.PersonaService;

@RestController
public class PersonaServiceRest {

	/*
	 * getPersona getNombre
	 */

	@GetMapping("/persona")
	public Persona getPersona(@RequestParam Integer id) {
		PersonaService ps = new PersonaService();

		return ps.getData(id);

	}

	@PostMapping("/newPersona")
	public void setPersona(@RequestBody String nombre) {
		PersonaService ps = new PersonaService();

		ps.setData(nombre);
	}

	@GetMapping("/saludo")
	public String saludo() {
		String a = "Hola";

		return a;
	}

}
