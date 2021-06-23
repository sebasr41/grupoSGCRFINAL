package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="OFFICES")
public class Offices {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offic_officeCode")
	private Long officeCode;//varchar clave principal
	
	
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "offic_city")
	private String city;
	
	@Min(value = 1,message = "debe ingresar un valor inferior o igual a 1 carcteres" )
	@Max(value = 50,message = "debe ingresar un valor inferior o igual a 50 carcteres" )
	@Column(name = "offic_phone")
	private int phone;
    
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "offic_addressLine1")
	private String addressLine1;
	

	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@Column(name = "offic_addressLine2")
	private String addressLine2;
	
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@Column(name = "offic_state")
	private String state;//creo q es string
	
	@Size(max = 50, message = " ingrese un valor inferior o igual a 50 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "offic_country")
	private String country;

	@Size(max = 15, message = " ingrese un valor inferior o igual a 15 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "offic_postalCode")
	private String postalCode;

	@Size(max = 10, message = " ingrese un valor inferior o igual a 10 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "offic_territory")
	private String territory;
	/**
	 * 
	 */
	public Offices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Offices(Long officeCode, String city, int phone, String addressLine1,
			String addressLine2, String state,  String country, String postalCode,
			 String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}


	
	public Long getOfficeCode() {
		return officeCode;
	}



	public void setOfficeCode(Long officeCode) {
		this.officeCode = officeCode;
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
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the territory
	 */
	public String getTerritory() {
		return territory;
	}
	/**
	 * @param territory the territory to set
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}


	@Override
	public String toString() {
		return "Offices [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	
	
	}