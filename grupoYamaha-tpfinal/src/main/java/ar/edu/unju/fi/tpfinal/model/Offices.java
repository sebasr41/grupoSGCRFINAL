package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="OFFICES")
public class Offices {	
	
	@NotNull
	@Id
	@Column(name = "offic_officeCode",length = 10, nullable = false)
	private String officeCode;//varchar clave principal
	
	@NotNull
	@Column(name = "offic_city",length = 50, nullable = false)
	private String city;
	
	@NotNull
	@Column(name = "offic_phone",length = 50, nullable = false)
	private int phone;
	
	@NotNull
	@Column(name = "offic_addressLine1",length = 50, nullable = false)
	private String addressLine1;
	
	@Column(name = "offic_addressLine2",length = 50)
	private String addressLine2;
	
	@Column(name = "offic_state",length = 50)
	private String state;//creo q es string
	
	@NotNull
	@Column(name = "offic_country",length = 50, nullable = false)
	private String country;
	
	@NotNull
	@Column(name = "offic_postalCode",length = 15, nullable = false)
	private String postalCode;
	
	@NotNull
	@Column(name = "offic_territory",length = 10, nullable = false)
	private String territory;
	/**
	 * 
	 */
	public Offices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Offices(@NotNull String officeCode, @NotNull String city, @NotNull int phone, @NotNull String addressLine1,
			String addressLine2, String state, @NotNull String country, @NotNull String postalCode,
			@NotNull String territory) {
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


	
	public String getOfficeCode() {
		return officeCode;
	}



	public void setOfficeCode(String officeCode) {
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