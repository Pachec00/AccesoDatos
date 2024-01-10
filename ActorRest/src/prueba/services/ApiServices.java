package prueba.services;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modelo.Actor;

@RestController
public class ApiServices {

	
	@GetMapping("/nombre")
	public Actor getNombreById(@RequestParam Integer id) throws SQLException {
		Actor a = new Actor();
		ActorService as = new ActorService();
		a = as.consultarNombre(id);
		
		return a;
				
	}
}
