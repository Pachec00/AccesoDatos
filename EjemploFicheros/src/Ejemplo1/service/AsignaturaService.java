package Ejemplo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Ejemplo1.modelo.Asignatura;

public class AsignaturaService {

	public List<Asignatura> consultarAsignatura(){
		List<Asignatura> lista = new ArrayList<Asignatura>();
		for(int i = 0; i < 100; i++) {
			Asignatura a = new Asignatura();
			if(i%2==0) {
				a.setCiclo("DAM");
			}else {
				a.setCiclo("DAW");
			}
			a.setNombre("Ejemplo de asignatura" + new Random().nextInt());
			a.setId(i);
			lista.add(a);
		}
		return lista;
		
	}
}
