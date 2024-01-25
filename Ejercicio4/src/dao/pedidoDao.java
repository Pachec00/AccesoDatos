package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pedido;

public class pedidoDao {

	
	public void insertarPedidoDao(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		
		
		try {
			String sql = "insert into pedidos values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, pedido.getIdPedido());
			stmt.setDate(2, pedido.getFechaPedido());
			stmt.setDate(3, pedido.getFechaEntrega());
			stmt.setString(4, pedido.getCliente());
			stmt.execute();
		}finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}
