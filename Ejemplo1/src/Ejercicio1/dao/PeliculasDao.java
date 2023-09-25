package Ejercicio1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Ejercicio1.modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			String sql = "select * from film";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setTitulo(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				peliculas.add(p);
			}
			
			for (Iterator iterator = peliculas.iterator(); iterator.hasNext();) {
				Pelicula pelicula = (Pelicula) iterator.next();
				if (pelicula.getLongitud() >= 100) {
					iterator.remove();
				}
				
			}
			return peliculas;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}
}
