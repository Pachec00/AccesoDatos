package services;

import java.sql.Connection;
import java.sql.SQLException;

import dao.usuarioDao;
import modelo.Usuarios;

public class usuarioService {

	private OpenConnection openConnection;

	public usuarioService() {
		openConnection = new OpenConnection();
	}

	public void registrarUsuario(Usuarios user) throws SQLException, usuarioServiceException {
		Connection conn = null;

		try {

			conn = openConnection.getConnection();

			usuarioDao ud = new usuarioDao();

			Usuarios u = ud.consultarUsuarioDao(conn, user.getEmail());

			if (u == null) { // Usuario no existe ( se puede registrar )
				ud.insertarUsuariosDao(conn, user);
				System.out.println("Usuario registrado");
			} else {
				throw new usuarioServiceException("El email ya existe");
			}

		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}
	}

	public Usuarios servicioLogin(String email, String pass) throws SQLException, usuarioServiceException {
		Connection conn = null;

		try {

			conn = openConnection.getConnection();
			usuarioDao ud = new usuarioDao();
			Usuarios u = ud.consultarUsuarioDao(conn, email);

			if (u != null) {
				if (u.getEmail().equals(email) || u.getPass().equals(pass)) {
					System.out.println("Sesion iniciada");
					return u;
				} else {
					throw new usuarioServiceException("El email o contraseña no coincide");
				}
			} else {
				throw new usuarioServiceException("El usuario no existe");
			}

		} finally {
			try {
				conn.close();
			} catch (Exception e) {

			}
		}

	}
}
