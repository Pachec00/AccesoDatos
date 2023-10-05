package app;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.LineaPedido;
import modelo.Pedido;
import service.PedidosService;
import service.PedidosServiceException;

public class App {

	public static void main(String[] args) throws PedidosServiceException {
		PedidosService service = new PedidosService();
		
		Pedido p = new Pedido();
		p.setIdPedido(6);
		p.setCliente("Fabio");
		LocalDate fecha = LocalDate.now();
		p.setFechaEntrega(Date.valueOf(fecha));
		p.setFechaPedido(Date.valueOf(fecha));
		
		LineaPedido l = new LineaPedido();
		l.setArticulo("Algo");
		l.setPrecio(1);
		
		
		List<LineaPedido> a = new ArrayList<>();
		a.add(l);
		p.setArticulos(a);
		
		service.registrarPedido(p);
		
	}
}
