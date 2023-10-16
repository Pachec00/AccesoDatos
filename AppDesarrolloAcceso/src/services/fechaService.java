package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.fechaDao;
import modelo.Fechas;

public class fechaService {

	private OpenConnection openConnection;

	public fechaService() {
		openConnection = new OpenConnection();
	}

	public List<Fechas> consultarFechaService() throws SQLException {
		Connection conn = null;

		try {

			conn = openConnection.getConnection();

			fechaDao fd = new fechaDao();

			return fd.consultarFechaDao(conn, 2023, 3);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}
}
