<<<<<<< HEAD
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String semana;
	private Integer simple;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public Integer getSimple() {
		return simple;
	}

	public void setSimple(Integer simple) {
		this.simple = simple;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", semana=" + semana + ", simple=" + simple + "]";
	}

}
=======
package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String semana;
	private Integer simple;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public Integer getSimple() {
		return simple;
	}

	public void setSimple(Integer simple) {
		this.simple = simple;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", semana=" + semana + ", simple=" + simple + "]";
	}

}
>>>>>>> branch 'main' of https://github.com/Pachec00/AccesoDatos.git
