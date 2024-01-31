package ceu.ad.tema4.ejercicio2.service;

import java.util.List;

import org.hibernate.Session;

import ceu.ad.tema4.ejercicio1.jpa.HibernateUtil;
import ceu.ad.tema4.ejercicio1.service.SerieNotFoundException;
import ceu.ad.tema4.ejercicio2.modelo.Articulo;
import ceu.ad.tema4.ejercicio2.modelo.Cliente;
import ceu.ad.tema4.ejercicio2.modelo.Pedido;
import ceu.ad.tema4.ejercicio2.modelo.PedidoLinea;
import jakarta.persistence.PersistenceException;

public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(cliente);
			session.getTransaction().commit();
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear un nuevo cliente " + e.getStackTrace());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {

			}
		}
	}

	@Override
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();

			List<PedidoLinea> listaLinea = pedido.getLineas();
			Integer contador = 1;
			for (int i = 0; i < listaLinea.size(); i++) {
				listaLinea.get(i).setNumLinea(contador);
				contador++;
			}

			session.persist(pedido);
			session.getTransaction().commit();

			return pedido;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error registrando nueva serie " + e.getStackTrace());
			e.printStackTrace();
			throw new PedidosClientesServiceException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException, SerieNotFoundException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactoy().openSession();
			session.getTransaction().begin();
			session.persist(articulo);
			session.getTransaction().commit();

			return articulo;
		} catch (PersistenceException e) {
			session.getTransaction().rollback();
			System.err.println("Error registrando nueva serie " + e.getStackTrace());
			e.printStackTrace();
			throw new SerieNotFoundException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
	}

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		// TODO: IMPLEMENTAR...
		return null;
	}

}
