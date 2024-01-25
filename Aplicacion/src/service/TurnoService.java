package service;

import org.hibernate.Session;

import jakarta.persistence.PersistenceException;
import jpa.HibernateUtil;
import modelo.Turno;

public class TurnoService {

	public void insertarTurno(Turno turno) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(turno);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}