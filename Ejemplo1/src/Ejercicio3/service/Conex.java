package Ejercicio3.service;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex {

public Conex getConnection1() throws SQLException {
		
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver ="org.mariadb.jdbc.Driver";
		String usuario = "root";
		String contraseña = "root";
		
		try {
			Class.forName(claseDriver);
			return (Conex) DriverManager.getConnection(urlConexion,usuario,contraseña);
		
		}catch(ClassNotFoundException e) {
			System.out.println("No se encuentra la clase del driver");
			
			throw new SQLException("No se ha encontrado la clase driver",e);
		}
	}
}
