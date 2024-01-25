package service;

import org.hibernate.Session;


import jakarta.persistence.PersistenceException;
import jpa.HibernateUtil;
import modelo.Usuario;

public class UsuarioService {

	public Usuario consultarUsuario(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			return session.get(Usuario.class, id);
		}
		catch(PersistenceException e) {
			throw e;
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
	}
}
