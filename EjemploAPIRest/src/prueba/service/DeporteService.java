package prueba.service;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import prueba.modelo.Deporte;

@RestController
public class DeporteService {

	@GetMapping("/deporte")
	public Deporte getDeporte(@RequestParam Integer id) throws DeporteNotFoundException {
		Deporte d = new Deporte();
		d.setId(id);
		if ( id == 99 ) {
			throw new DeporteNotFoundException("No existe el deporte con id 99");
		}
		d.setNombre("Futbol");
		d.setAficionados(2);
		return d;
	}
	
	@PostMapping("/deporte")
	public Deporte getDeporte(@RequestBody Deporte deporte) {
		System.out.println("Creando deporte...");
		deporte.setId(1);
		System.out.println("Deporte creado");
		return deporte;
	}
}
