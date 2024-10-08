package prueba;

import prueba.clienteRest.ClientRest;
import prueba.modelo.Persona;

public class Test {

	public static void main(String[] args) {
		ClientRest client = new ClientRest("http://localhost:8080", 2000);
		Persona persona = client.getPersona(1);
		System.out.println(persona.toString());
	}
}
