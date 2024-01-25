package Ejercicio3.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagos {

	private Integer cliente_id;
	private BigDecimal amount;
	private LocalDate fecha;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	@Override
	public String toString() {
		return "Pagos [amount=" + amount + ", fecha=" + fecha + "]";
	}

}
