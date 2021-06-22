package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	private Long id;

	@Column(name="us_nombreUsuario")
	private String nombreUsuario;
	
	@Column(name="us_password")
	private String password;
	
	@Column(name="us_rol")
	private String rol;
	
	
	@OneToOne
	private Employees Employees;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombreUsuario
	 * @param password
	 * @param rol
	 * @param employees
	 */
	public Usuario(Long id, String nombreUsuario, String password, String rol,
			ar.edu.unju.fi.tpfinal.model.Employees employees) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
		Employees = employees;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the employees
	 */
	public Employees getEmployees() {
		return Employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Employees employees) {
		Employees = employees;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", rol=" + rol
				+ ", Employees=" + Employees + "]";
	}
	
}