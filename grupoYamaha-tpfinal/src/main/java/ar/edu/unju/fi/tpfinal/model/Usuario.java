package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
@Entity
@Table(name="USUARIOS")
public class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@NotBlank(message = "La celda no debe quedar vacia") 
    @Column(unique = true)
    private String nombreUsuario;
	@NotBlank(message = "La celda no debe quedar vacia")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    @Valid
    @Autowired
    @OneToOne
    private Customer customers;
    /**
     * constructor de la clase usuario
     */
    public Usuario() {
    }
    /**
     * Constructor de lso atributos de la clase Usuario
     * @param nombreUsuario
     * @param password
     */
    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    
    /**
     * Método "getter"
     * @return customers de la clase Customer
     */
    public Customer getCustomers() {
		return customers;
	}
    /**
     * Método "setter" 
     * @param customers, carga un valor de la classe Customer
     */
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	/**
	 * Método "getter" 
	 * @return id, retorna un valor tipo int
	 */
	public int getId() {
        return id;
    }
	/**
	 * Método "setter"
	 * @param id carga un valor tipo int
	 */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Método "getter" 
	 * 
     * @return nombreUsuario, retorna un valor tipo String
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
     * Método "setter" 
     * @param nombreUsuario, carga un valor tipo String
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    /**
     * Método "getter" 
     * @return password, retorna un valor tipo String
     */
    public String getPassword() {
        return password;
    }
    /**
     * Método "setter" 
     * @param password, carga un valor tipo String
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Método "getter" 
     * @return roles de la clase Rol
     */
    public Set<Rol> getRoles() {
        return roles;
    }
    /**
     * Método "setter" 
     * @param roles, carga valor de la clase Rol
     */
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", roles=" + roles
				+ ", customers=" + customers + "]";
	}
    
}
