package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Registros;
import services.usuarioServiceException;

public class registroDao {

	public List<Registros> consultarRegistrosDao(Connection conn, Integer id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			List<Registros> registros = new ArrayList<>();
			Registros r = new Registros();
			String sql = "select * from registros where id_usuario = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				r.setId_usuario(rs.getInt("id_usuario"));
				r.setId_registro(rs.getInt("id_registro"));
				r.setDescripcion(rs.getString("descripcion"));
				r.setNum_horas(rs.getDouble("num_horas"));
				r.setFecha(rs.getDate("fecha"));
				registros.add(r);
			}

			return registros;

		} finally {
			try {

			} catch (Exception e) {
				stmt.close();
			}
		}
	}

	public void insertarRegistroDao(Connection conn, Registros r, LocalDate fecha) throws SQLException, usuarioServiceException {
		PreparedStatement stmt = null;

		try {

			List<Registros> registros = consultarRegistrosDao(conn, r.getId_usuario());

			if (registros.isEmpty()) { // No hay registros , se puede insertar

				Date date = java.sql.Date.valueOf(fecha);
				String sql = "insert into registros (id_usuario, fecha, num_horas, descripcion,id_registro) values(?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, r.getId_registro());
				stmt.setDate(2, date);
				stmt.setDouble(3, r.getNum_horas());
				stmt.setString(4, r.getDescripcion());
				stmt.setInt(5, r.getId_registro());
				stmt.execute();

			} else {
				throw new usuarioServiceException("El registro ya existe");
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}
	}

}
