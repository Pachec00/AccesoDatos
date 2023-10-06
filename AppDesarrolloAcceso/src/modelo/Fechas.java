package modelo;

import java.sql.Date;

public class Fechas {

	private Date fecha;
	private Integer year;
	private Integer evaluacion;
	private Integer disponibilidad;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
