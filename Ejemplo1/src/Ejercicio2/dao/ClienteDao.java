package Ejercicio2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio2.modelo.Cliente;

public class ClienteDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			String sql = "select * from customer";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Cliente p = new Cliente();
				p.setId(rs.getInt("customer_id"));
				p.setFirt_name(rs.getString("first_name"));
				p.setLast_name(rs.getString("Last_name"));
				p.setEmail(rs.getString("email"));
				p.setActive(rs.getBoolean("active"));
				clientes.add(p);
			}

			return clientes;
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}
}
