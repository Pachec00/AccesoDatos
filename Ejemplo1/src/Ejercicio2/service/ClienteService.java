package Ejercicio2.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Ejercicio1.service.PeliculasServiceException;
import Ejercicio2.dao.ClienteDao;
import Ejercicio2.modelo.Cliente;

public class ClienteService {

	private OpenConnection openConnection;

	public ClienteService() {
		openConnection = new OpenConnection();
	}

	public Map<String, Cliente> consultarClientes() throws PeliculasServiceException {

		Connection conn = null;
		try {
			conn = openConnection.getConnection();
			ClienteDao dao = new ClienteDao();
			List<Cliente> listaCliente = dao.consultarClientes(conn);
			Map<String, Cliente> mapa = new HashMap<>();

			for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();
				mapa.put(cliente.getEmail(), cliente);

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
