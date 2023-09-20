package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

public Connection getConnection() throws SQLException {
		
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver ="org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String contraseña = "sakila";
		
		try {
			Class.forName(claseDriver);
			return DriverManager.getConnection(urlConexion,usuario,contraseña);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			throw new SQLException("No se ha encontrado la clase driver",e);
		}
	}
}
