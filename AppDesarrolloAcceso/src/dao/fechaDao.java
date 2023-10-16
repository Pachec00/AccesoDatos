package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Fechas;

public class fechaDao {

	public List<Fechas> consultarFechaDao(Connection conn, Integer year, Integer ev) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			List<Fechas> fechas = new ArrayList<Fechas>();
			Fechas f = new Fechas();
			String sql = "select * from fechas where año = ? and evaluacion = ? ";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, year);
			stmt.setInt(2, ev);
			rs = stmt.executeQuery();

			if (rs.next()) {
				f.setYear(rs.getInt("año"));
				f.setEvaluacion(rs.getInt("evaluacion"));
				f.setDisponibilidad(rs.getInt("disponibilidad"));
				f.setFecha(rs.getDate("fecha"));
				fechas.add(f);
			}

			return fechas;

		} finally {
			try {

			} catch (Exception e) {
				conn.close();
			}
		}
	}
}
