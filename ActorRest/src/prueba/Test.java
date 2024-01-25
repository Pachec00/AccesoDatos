package prueba;

import modelo.Actor;
import prueba.services.ClientRest;

public class Test {
public static void main(String[] args) {
	ClientRest r = new ClientRest("http://localhost:8080", 2000);
	Actor a = r.getActor(1);
	System.out.println(a);
}
}
