package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CUSTOMERS")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_numero", nullable = false)//le pongo id
	private Long customerNumber;//int clave principal
		
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@NotBlank(message = "La celda no debe quedar vacia, igrese un Nombre de cliente, inferior a 50 caracteres")
	@Column(name = "cust_customername")
	private String customerName;
	
	@NotBlank(message = "La celda no debe quedar vacia, igrese un Nombre apellido, inferior a 50 caracteres")
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@Column(name = "cust_contactlastname")
	private String contactLastName;
	
	@NotBlank(message = "La celda no debe quedar vacia, igrese el nombre de contacto, inferior a 50 caracteres")
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@Column(name = "cust_contactfirstname")
	private String contactFirstName;
	
	@NotBlank(message = "La celda no debe quedar vacia, igrese el numero de telefono, inferior a 50 caracteres")
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@Column(name = "cust_phone")
	private String phone;//es varchar es la variable
	
	@Size(max = 50, message = "debe ingresar un valor inferior a 50 carcteres")
	@NotBlank(message = "La celda no debe quedar vacia, igrese dirección, inferior a 50 caracteres")
	@Column(name = "cust_addressLine1")
	private String addressLine1;
	
	@Size(max = 50, message = "debe ingresar un valor inferior a 50 carcteres")
	@Column(name = "cust_addressLine2")
	private String addressLine2;
	
	@Size(max = 50, message = "debe ingresar un valor inferior a 50 carcteres")
	@NotBlank(message = "La celda no debe quedar vacia, igrese un Nombre de a ciudad, inferior a 50 caracteres")
	@Column(name = "cust_city")
	private String city;
	
	@Size(max = 50, message = "debe ingresar un valor inferior a 50 carcteres")
	@Column(name = "cust_state")
	private String state;
	
	@Size(max = 15, message = "debe ingresar un valor inferior a 15 carcteres")
	@Column(name = "cust_postalCode")
	private String postalCode;
	
	@Size(max = 50, message = "debe ingresar un valor inferior a 50 carcteres")
	@NotBlank(message = "La celda no debe quedar vacia, igrese un nombre de pais, inferior a 50 caracteres")
	@Column(name = "cust_coutry")
	private String coutry;
	
	@DecimalMin(value = "0.01")
	@Column(name = "cust_creditlimit")
	private Double creditLimit;

	@ManyToOne
	@Autowired
	@JoinColumn(name="empl_employeenumber")
	private Employees employees;
	
	/**
	 * 
	 */
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Customers(@NotNull Long customerNumber, @NotNull String customerName, @NotNull String contactLastName,
			@NotNull String contactFirstName, @NotNull String phone, @NotNull String addressLine1, String addressLine2,
			@NotNull String city, String state, String postalCode, @NotNull String coutry, Double creditLimit,
			Employees employees) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.coutry = coutry;
		this.creditLimit = creditLimit;
		this.employees = employees;
	}




	/**
	 * @return the customerNumber
	 */
	public Long getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the coutry
	 */
	public String getCoutry() {
		return coutry;
	}

	/**
	 * @param coutry the coutry to set
	 */
	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}


	/**
	 * @return the creditLimit
	 */
	public Double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
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
		return "Customers [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", coutry=" + coutry + ", creditLimit=" + creditLimit + ", employees="
				+ employees + "]";
	}
	
	

}
