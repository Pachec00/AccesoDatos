package modelo;

import java.sql.Date;

public class Registros {

	private Integer id_registro;
	private Integer id_usuario;
	private Date fecha;
	private double num_horas;
	private String descripcion;

	public Integer getId_registro() {
		return id_registro;
	}

	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(double num_horas) {
		this.num_horas = num_horas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
