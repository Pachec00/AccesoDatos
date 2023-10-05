package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.LineaPedido;


public class lineaDao {

	public void insertarLineaPedidoDao(Connection conn, LineaPedido linea) throws SQLException {
		PreparedStatement stmt = null;
		
		
		try {
			
			String sql = "insert into pedidos_lineas values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, linea.getIdPedido());
			stmt.setInt(2, linea.getNumeroLinea());
			stmt.setString(3, linea.getArticulo());
			stmt.setInt(4, linea.getPrecio());
			stmt.execute();
		}finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}

