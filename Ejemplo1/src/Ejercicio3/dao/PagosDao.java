package Ejercicio3.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio3.modelo.Pagos;

public class PagosDao {

	public List<Pagos> consultarPagosDao(Connection conn, Integer id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			List<Pagos> pagos = new ArrayList<Pagos>();
			String sql = "select * from payment where ? = customer_id";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pagos p = new Pagos();
				p.setAmount(rs.getBigDecimal("amount"));
				Date date = (rs.getDate("payment_date"));
				p.setFecha(date.toLocalDate());
				p.setCliente_id(id);
				pagos.add(p);
			}

			return pagos;
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}
}
