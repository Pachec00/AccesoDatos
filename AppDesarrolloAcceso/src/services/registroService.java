package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.registroDao;
import modelo.Registros;

public class registroService {

	private OpenConnection openConnection;

	public registroService() {
		openConnection = new OpenConnection();
	}

	public List<Registros> consultarRegistroService(Integer id) throws SQLException {
		Connection conn = null;

		try {

			conn = openConnection.getConnection();

			registroDao rd = new registroDao();

			return rd.consultarRegistrosDao(conn, id);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}
	
	
	public void insertarRegistroService(Registros r) throws SQLException, usuarioServiceException {
		Connection conn = null;
		
		try {
			
			conn = openConnection.getConnection();
			
			registroDao rd = new registroDao();
			
			Date date = r.getFecha();
			LocalDate fecha = date.toLocalDate();
			rd.insertarRegistroDao(conn, r, fecha);
			
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}
}
