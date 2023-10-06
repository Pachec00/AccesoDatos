package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuarios;

public class usuarioDao {

	public Usuarios consultarUsuarioDao(Connection conn, String email, String pass) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Usuarios u = new Usuarios();
			String sql = "select email, password from usuarios where ? = email and ? = password";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();

			while (rs.next()) {
				u.setEmail(rs.getString("email"));
				u.setPass(rs.getString("password"));
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
			
			String sql = "insert into usuarios values(?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getIdUsuario());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPass());
			stmt.setString(4, user.getNombre());
			stmt.setString(5, user.getApellidos());
			stmt.setString(6, user.getCiclo());
			user.setActivo(0);
			stmt.setInt(7, user.getActivo());
			
			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
}
