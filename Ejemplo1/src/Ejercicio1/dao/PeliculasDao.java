package Ejercicio1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1.modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> consultarPeliculas(Connection conn, Integer longitud) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			String sql = "select * from film where ? >= length";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, longitud);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setTitulo(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				peliculas.add(p);
			}

			return peliculas;
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}
}
