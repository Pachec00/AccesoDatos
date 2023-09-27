package Ejercicio2.app;

import java.util.HashMap;
import java.util.Map;

import Ejercicio1.service.PeliculasServiceException;
import Ejercicio2.modelo.Cliente;
import Ejercicio2.service.ClienteService;

public class App {

	public static void main(String[] args) {
		ClienteService service = new ClienteService();
		Map<String, Cliente> c = new HashMap<>();
		Cliente cliente = new Cliente();
		try {
			c = service.consultarClientes();
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
		cliente = c.get("MARILYN.ROSS@sakilacustomer.org");
		System.out.println(cliente);

	}
}
