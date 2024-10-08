package program.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import program.modelo.Persona;

@RestController
public class PersonaService {

	
	@GetMapping("/getPersona")
	public Persona getPersona(@RequestParam String nombre) {
		Persona persona = new Persona();
		persona.setNombre(nombre);
		
		return persona;
	}
	
	@PostMapping("/setPersona")
	public Persona setPersona(@RequestBody Persona persona) {
		System.out.println("Creando persona");
		persona.setId(1);
		System.out.println("Persona creada");
		return persona;
	}
}
