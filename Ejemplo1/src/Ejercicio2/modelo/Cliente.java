package Ejercicio2.modelo;

public class Cliente {

	private Integer id;
	private String firt_name;
	private String last_name;
	private String email;
	private Boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirt_name() {
		return firt_name;
	}

	public void setFirt_name(String firt_name) {
		this.firt_name = firt_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", firt_name=" + firt_name + ", last_name=" + last_name + ", email=" + email
				+ ", active=" + active + "]";
	}

}
