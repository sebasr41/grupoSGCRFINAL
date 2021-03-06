package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="EMPLOYEES")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empl_employeenumber")//le pongo id empl_id
	private Long employeeNumber;//int clave principal//int clave principal
	
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@Column(name = "empl_lastname")
	private String lastName;
	
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@Column(name = "empl_firstname")
	private String firstName;
	
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Size(max = 10, message = " ingrese un valor inferior o igual a 10 caracteres")
	@Column(name = "empl_extension")
	private String extension;
	
	@Size(max = 100, message = " ingrese un valor inferior o igual a 100 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "empl_email")
	private String email;
	
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@Column(name = "empl_jobtitle")
	private String jobTitle;
	
	@ManyToOne
	@Autowired
	@JoinColumn(name="offic_officeCode")
	private Office offices;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="reportsTo")
	private Employee employees;
	/**
	 * Constructor de clase Employe
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de atributos de clases
	 * @param employeeNumber
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param officeCode
	 * @param jobTitle
	 * @param offices
	 * @param employees
	 */
		
	public Employee(Long employeeNumber, String lastName, String firstName,
			String extension,  String email, String jobTitle,  Office offices,
			Employee employees) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.jobTitle = jobTitle;
		this.offices = offices;
		this.employees = employees;
	}
	
	/**
	 * 
	 * M??todo "getter",
	 * @return employeeNumber," muestra un valor" tipo Long
	 */
	public Long getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * M??todo "setter",
	 * @param employeeNumber,carga un valor tipo Long
	 */
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * M??todo "getter",
	 * @return lastName,  muestra un valor tipo String
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * M??todo "setter",
	 * @param lastName,carga un valor tipo String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * M??todo "getter",
	 * @return firstName, muestra un valor" tipo String
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * M??todo "setter",
	 * @param firstName ,carga un valor tipo String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * M??todo "getter",
	 * @return extension, muestra un valor tipo String
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * M??todo "setter",
	 * @param extension ,carga un valor tipo String
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * 
	 * M??todo "getter",
	 * @return email, muestra un valor tipo String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * M??todo "setter",
	 * @param email,carga un valor tipo String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * M??todo "getter",
	 * @return jobTitle muestra un valor tipo String
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * M??todo "setter",
	 * @param jobTitle, carga un valor tipo String 
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * M??todo "getter",
	 * @return offices, muestra un valor tipo String
	 */
	public Office getOffices() {
		return offices;
	}
	/**
	 * M??todo "setter"
	 * @param offices, carga un valor tipo String 
	 */
	public void setOffices(Office offices) {
		this.offices = offices;
	}
	/**
	 * M??todo "getter",
	 * @return employees, muestra un valor de la clase employee
	 */
	public Employee getEmployees() {
		return employees;
	}
	/**
	 * M??todo "setter",
	 * @param employees, carga un valor de la clase employee 
	 */
	public void setEmployees(Employee employees) {
		this.employees = employees;
	}


}
