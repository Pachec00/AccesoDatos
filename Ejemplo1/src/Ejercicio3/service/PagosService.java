package Ejercicio3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Ejercicio1.service.PeliculasServiceException;
import Ejercicio2.dao.ClienteDao;
import Ejercicio2.modelo.Cliente;
import Ejercicio2.service.OpenConnection;
import Ejercicio3.dao.PagosDao;
import Ejercicio3.modelo.Pagos;

public class PagosService {

	private OpenConnection openConnection;

	public PagosService() {
		openConnection = new OpenConnection();
	}

	public Map<String, List<Pagos>> consultarPagos() throws PeliculasServiceException {

		Connection conn = null;
		try {
			conn = openConnection.getConnection();
			ClienteDao dao = new ClienteDao();
			PagosDao d = new PagosDao();
			List<Cliente> listaCliente = dao.consultarClientes(conn);
			List<Pagos> listaPagos;
			Map<String, List<Pagos>> mapa = new HashMap<>();

			for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();
				listaPagos = d.consultarPagosDao(conn, cliente.getId());
				mapa.put(cliente.getEmail(), listaPagos);

			}

			return mapa;
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
