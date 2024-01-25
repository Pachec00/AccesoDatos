package Ejemplo1;

import java.util.List;

import Ejemplo1.csv.CsvSampleService;
import Ejemplo1.csv.FicheroExceptiion;
import Ejemplo1.modelo.Asignatura;
import Ejemplo1.service.AsignaturaService;

public class App {
public static void main(String[] args) {
	CsvSampleService cs = new CsvSampleService();
	
	try {
		//cs.escribirCsvAsignaturas("C:\\Users\\frodriguez0023\\Desktop\\Fichero\\hola.csv");
		List<Asignatura> lista = cs.leerCsv("C:\\\\Users\\\\frodriguez0023\\\\Desktop\\\\Fichero\\\\hola.csv");
		for(Asignatura asignatura : lista) {
			System.out.println(asignatura);
		}
	} catch (FicheroExceptiion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
