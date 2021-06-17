package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="EMPLOYEES")
public class Employees {
	

	@NotNull
	@Id
	@Column(name = "empl_employeenumber", nullable = false)//le pongo id empl_id
	private Long employeeNumber;//int clave principal//int clave principal
	
	@NotNull
	@Column(name = "empl_lastname",length = 50, nullable = false)
	private String lastName;
	
	@NotNull
	@Column(name = "empl_firstname",length = 50, nullable = false)
	private String firstName;
	
	@NotNull
	@Column(name = "empl_extension",length = 10, nullable = false)
	private String extension;
	
	@NotNull
	@Column(name = "empl_email",length = 100, nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "empl_jobtitle",length = 50, nullable = false)
	private String jobTitle;
	
	@NotNull
	@ManyToOne
	@Autowired
	@JoinColumn(name="offic_officeCode", nullable = false)
	private Offices offices;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="reportsTo")
	private Employees employees;
	/**
	 * 
	 */
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
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
		
	public Employees(@NotNull Long employeeNumber, @NotNull String lastName, @NotNull String firstName,
			@NotNull String extension, @NotNull String email, @NotNull String jobTitle, @NotNull Offices offices,
			Employees employees) {
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
	 * @return the employeeNumber
	 */
	public Long getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the offices
	 */
	public Offices getOffices() {
		return offices;
	}
	/**
	 * @param offices the offices to set
	 */
	public void setOffices(Offices offices) {
		this.offices = offices;
	}
	/**
	 * @return the employees
	 */
	public Employees getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Employees [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", jobTitle=" + jobTitle + ", offices=" + offices
				+ ", employees=" + employees + "]";
	}
	

	
	
}
