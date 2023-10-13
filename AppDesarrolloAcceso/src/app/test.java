package app;

import java.sql.SQLException;

import dao.usuarioDao;
import modelo.Usuarios;
import services.usuarioService;
import services.usuarioServiceException;

public class test {

	public static void main(String[] args) throws SQLException, usuarioServiceException {
		
		Usuarios user = new Usuarios();
		
		user.setNombre("a");
		user.setApellidos("Rodriguez Yesares");
		user.setEmail("F@");
		user.setPass("123");
		user.setCiclo("DAM");
		
		usuarioService us = new usuarioService();
		us.servicioLogin(user.getEmail(), user.getPass());
		//us.registrarUsuario(user);
	}

}
