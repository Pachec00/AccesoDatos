package prueba.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameServices {
	
	@GetMapping("/name")
	public String getNombre() {
		return "Fabio";
	}
	
	@GetMapping("/potencia/{numero}/{potencia}")
	
	public double potencia( @PathVariable Integer numero, @PathVariable Integer potencia) {
		return Math.pow(numero, potencia);
	}
}
