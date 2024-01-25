package Ejercicio1.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import Ejercicio1.dao.PeliculasDao;
import Ejercicio1.modelo.Pelicula;

public class PeliculasServices {

	private OpenConnection openConnection;

	public PeliculasServices() {
		openConnection = new OpenConnection();

	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasServiceException {

		Connection conn = null;
		try {
			conn = openConnection.getConnection();
			PeliculasDao dao = new PeliculasDao();
			List<Pelicula> peliculas = dao.consultarPeliculas(conn, longitud);

//			for (Iterator iterator = peliculas.iterator(); iterator.hasNext();) {
//				Pelicula pelicula = (Pelicula) iterator.next();
//				if (pelicula.getLongitud() >= 100) {
//					iterator.remove();
//				}
//
//			}
			return peliculas;
		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new PeliculasServiceException("Error al obtener actores de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}
}
