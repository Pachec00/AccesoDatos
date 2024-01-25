package service;

import java.sql.Connection;

import dao.lineaDao;
import dao.pedidoDao;
import modelo.LineaPedido;
import modelo.Pedido;

public class PedidosService {

	private OpenConnection openConnection;

	public PedidosService() {
		openConnection = new OpenConnection();
	}

	public void registrarPedido(Pedido pedido) throws PedidosServiceException {
		Connection conn = null;
		pedidoDao p = new pedidoDao();
		lineaDao l = new lineaDao();
		try {
			conn = openConnection.getConnection();

			p.insertarPedidoDao(conn, pedido);

			for (LineaPedido linea : pedido.getArticulos()) {
				linea.setIdPedido(pedido.getIdPedido());
				linea.setNumeroLinea(1);
				l.insertarLineaPedidoDao(conn, linea);
				
			}

		} catch (Exception e) {
			System.err.println("Ha habido un error en la base de datos : ");
			throw new PedidosServiceException("Error al obtener actores de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
				// TODO: handle exception
			}
		}
	}
}
