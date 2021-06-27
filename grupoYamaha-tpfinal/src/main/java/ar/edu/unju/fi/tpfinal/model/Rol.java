package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import com.sun.istack.NotNull;

import ar.edu.unju.fi.tpfinal.enums.RolNombre;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RolNombre rolNombre;
    /**
     * constructor de la clase Rol
     */
    public Rol() {
    }
    /**
     * Constructor de atributo rolNombre de la clase Rol
     * @param rolNombre
     */
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    /**
     * Método "getter" 
     * @return
     */
    public int getId() {
        return id;
    }
    /**
     * Método "setter" 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Método "getter" 
     * @return
     */
    public RolNombre getRolNombre() {
        return rolNombre;
    }
    /**
     * 
     * Método "setter" 
     * @param rolNombre, sirve para "cargar un valor" de la clase RolNombre
     */
    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
