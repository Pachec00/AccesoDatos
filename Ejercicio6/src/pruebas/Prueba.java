package pruebas;

import java.util.List;

import clients.CiudadErrorException;
import clients.CiudadNoEncontradaException;
import clients.CiudadesClientImpl;
import modelo.Ciudad;

public class Prueba {

	public static void main(String[] args) throws CiudadNoEncontradaException, CiudadErrorException {
		CiudadesClientImpl ci = new CiudadesClientImpl("http://10.50.22.37:8080/", 2000);
		long l = 1;
		Ciudad ciudad = new Ciudad();
		ciudad.setDescripcion("n");
		ciudad.setCountryId(87L);
		ci.updateCity(ciudad);
		System.out.println(ciudad);
	}
}
