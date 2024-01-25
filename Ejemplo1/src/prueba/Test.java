package prueba;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.setId(1);
		a.setColor("Rojo");
		a.setRaza("Perro");
		a.setFechaNacimiento(LocalDate.now());
		System.out.println(a);
	}

}
