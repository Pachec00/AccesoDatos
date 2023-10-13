package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuarios;

public class usuarioDao {

	public Usuarios consultarUsuarioDao(Connection conn, String email) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Usuarios u = new Usuarios();
			String sql = "select * from usuarios where  email = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				u.setEmail(rs.getString("email"));
				u.setPass(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellidos(rs.getString("apellidos"));
				u.setCiclo(rs.getString("ciclo"));
				u.setActivo(rs.getInt("activo"));
			}else {
				return null;
			}

			return u;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}

	}
	
	public void insertarUsuariosDao(Connection conn,Usuarios user) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			
			String sql = "insert into usuarios (email,password,nombre,apellidos,ciclo,activo) values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getNombre());
			stmt.setString(4, user.getApellidos());
			stmt.setString(5, user.getCiclo());
			user.setActivo(0);
			stmt.setInt(6, user.getActivo());
			stmt.execute();
			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
}
