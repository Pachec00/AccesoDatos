package Ejemplo1.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ejemplo1.modelo.Asignatura;
import Ejemplo1.service.AsignaturaService;

public class CsvSampleService {

	public void escribirCsvAsignaturas(String ruta) throws FicheroExceptiion {
		AsignaturaService es = new AsignaturaService();
		List<Asignatura> lista = es.consultarAsignatura();

		File file = new File(ruta);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			for (Asignatura asignatura : lista) {
				writer.write(asignatura.toCsv() + "\n");
			}
		} catch (IOException e) {
			throw new FicheroExceptiion("Error escribiendo csv", e);
		} finally {
			try {
				writer.close();
			} catch (Exception e2) {

			}
		}

	}

	public List<Asignatura> leerCsv(String ruta) throws FicheroExceptiion {
		File file = new File(ruta);
		Scanner sc = null;
		try {
			List<Asignatura> lista = new ArrayList<Asignatura>();
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				lista.add(a);
			}

			return lista;

		} catch (FileNotFoundException e) {
			throw new FicheroExceptiion("No existe el fichero", e);
		}
	}
}
