package app;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Registros;
import services.registroService;
import services.usuarioServiceException;

public class test {

	public static void main(String[] args) throws SQLException, usuarioServiceException {
		
		Registros r = new Registros();
//		r.setId_usuario(3);
//		r.setDescripcion("Registro 1");
//		LocalDate l = LocalDate.now();
//		Date date = Date.valueOf(l);
//		r.setFecha(date);
//		r.setNum_horas(1);
//		r.setId_registro(1);
		
		registroService rs = new registroService();
		List<Registros> lista = new ArrayList<>();
		lista = rs.consultarRegistroService(3);
		
		System.out.println(lista);
	}

}
