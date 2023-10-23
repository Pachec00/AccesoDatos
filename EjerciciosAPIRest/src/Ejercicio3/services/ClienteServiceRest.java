package Ejercicio3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ejercicio1.service.PeliculasServiceException;
import Ejercicio2.modelo.Cliente;
import Ejercicio2.service.ClienteService;

@RestController
public class ClienteServiceRest {

	@GetMapping("/clientes")
	public Cliente getClientes(@RequestParam String email) throws PeliculasServiceException {
		ClienteService cs = new ClienteService();
		Map<String, Cliente> cliente = new HashMap<>();
		Cliente c = new Cliente();
		cliente = cs.consultarClientes();
		c = cliente.get(email);

		return c;

	}

}
