package Ejercicio3.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio3.modelo.Pagos;

public class PagosDao {

	public List<Pagos> consultarPagos(Connection conn, Integer id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pagos> pagos = new ArrayList<Pagos>();
			String sql = "select * from payment where customer_id = id";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Pagos p = new Pagos();
				p.setAmount(rs.getBigDecimal("amount"));
				Date date = (rs.getDate("payment_date"));
				p.setFecha(date.toLocalDate());
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
