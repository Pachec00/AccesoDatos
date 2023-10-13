package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

public Connection getConnection() throws SQLException {
		
		String urlConexion = "jdbc:mariadb://localhost:3306/ceu-fct";
		String claseDriver ="org.mariadb.jdbc.Driver";
		String usuario = "root";
		String contraseña = "root";
		
		try {
			Class.forName(claseDriver);
			return DriverManager.getConnection(urlConexion,usuario,contraseña);
		
		}catch(ClassNotFoundException e) {
			System.out.println("No se encuentra la clase del driver");
			
			throw new SQLException("No se ha encontrado la clase driver",e);
		}
	}
}
