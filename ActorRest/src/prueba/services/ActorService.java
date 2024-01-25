package prueba.services;

import java.sql.Connection;
import java.sql.SQLException;


import modelo.Actor;
import prueba.dao.ActorDao;

public class ActorService {
	
	private OpenConnection openConnection;

	public ActorService() {
		openConnection = new OpenConnection();
	}
	
	public Actor consultarNombre(Integer id) throws SQLException {
		
		Connection conn = null;
		
		try {
			
			conn = openConnection.getConnection();
			ActorDao ad = new ActorDao();
			Actor a = ad.consultarNombre(conn, id);
			
			return a;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
	}
}
