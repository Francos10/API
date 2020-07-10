package sigel.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nomuser")
	private String nomuser;
	
	@Column(name="password")
	private String password;

	@Column(name="email")
	private String email;
	
	public User() {}
	
	public User(int id, String nombre, String nomuser, String password, String email) {
		this.id = id;
		this.nombre = nombre;
		this.nomuser = nomuser;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNomuser() {
		return nomuser;
	}

	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", nomuser=" + nomuser + ", password=" + password + ", email=" + email + "]";
	}

}
