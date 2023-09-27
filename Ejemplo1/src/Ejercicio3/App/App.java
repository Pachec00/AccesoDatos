package Ejercicio3.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio1.service.PeliculasServiceException;
import Ejercicio2.modelo.Cliente;
import Ejercicio3.service.PagosService;

public class App {

	public static void main(String[] args) {
		PagosService service = new PagosService();
		Map<String, List> c = new HashMap<>();
		List cliente = new ArrayList<>();
		try {
			c = service.consultarPagos(80);
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
		cliente = c.get("MARILYN.ROSS@sakilacustomer.org");
		System.out.println(cliente);

	}

}
