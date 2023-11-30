package prueba;

import prueba.clienteRest.clientRest;
import prueba.modelo.Deporte;

public class Test {
public static void main(String[] args) {
	clientRest client = new clientRest("http://localhost:8080", 2000);
	Deporte deporte = client.getDeporte(63);
	System.out.println(deporte.toString());
	
//	Deporte d = client.crearDeporte(deporte);
//	System.out.println(d);
}
}
