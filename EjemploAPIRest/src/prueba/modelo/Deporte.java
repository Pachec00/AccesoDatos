package prueba.modelo;

import lombok.Data;

public @Data class Deporte {

	private Integer id;
	private String nombre;
	private Integer aficionados;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAficionados() {
		return aficionados;
	}
	public void setAficionados(Integer aficionados) {
		this.aficionados = aficionados;
	}
	@Override
	public String toString() {
		return "Deporte [id=" + id + ", nombre=" + nombre + ", aficionados=" + aficionados + "]";
	}
	
	
	
	
	
	
}
