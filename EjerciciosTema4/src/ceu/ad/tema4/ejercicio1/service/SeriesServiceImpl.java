package ceu.ad.tema4.ejercicio1.service;

import java.util.List;

import org.hibernate.Session;

import ceu.ad.tema4.ejercicio1.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio1.modelo.Serie;
import jakarta.persistence.PersistenceException;

public class SeriesServiceImpl implements SeriesService {

	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {
		return null;
		// TODO: IMPLEMENTAR POR EL ALUMNO...
	}
	
	
	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		return null;
		// TODO: IMPLEMENTAR POR EL ALUMNO...
		
	}
	
	@Override
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(serie);
			session.getTransaction().commit();
			
			
		} catch (PersistenceException e) {
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		// TODO: IMPLEMENTAR POR EL ALUMNO...
		return serie;
		
	}
	
	
	@Override
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		// TODO: IMPLEMENTAR POR EL ALUMNO...
		
	}
	
	
	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		// TODO: IMPLEMENTAR POR EL ALUMNO...
		
	}
	
	
}
