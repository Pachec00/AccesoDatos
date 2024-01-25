package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private long idPedido;
	private Date fechaPedido;
	private Date fechaEntrega;
	private String cliente;
	private List<LineaPedido> articulos = new ArrayList<>();
	
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public List<LineaPedido> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<LineaPedido> articulos) {
		this.articulos = articulos;
	}
	
	
	
	
}
