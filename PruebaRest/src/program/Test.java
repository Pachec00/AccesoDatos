package program;

import program.clienteRest.ClientRest;
import program.modelo.Persona;

public class Test {

	public static void main(String[] args) {
		
		ClientRest client = new ClientRest("http://localhost:8080", 2000);
		Persona persona = new Persona();
		
		persona.setId(2);
		persona.setEdad(21);
		persona.setNombre("Fabio");
		client.setPersona(persona);
		
		
		Persona p = client.getPersona(2);
		System.out.println(p.toString());
		
		
	}
}
