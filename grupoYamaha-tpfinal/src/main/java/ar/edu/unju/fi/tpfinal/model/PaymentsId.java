package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class PaymentsId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "customer_number")
	private Customers customerNumber;

	@NotNull
	@Column(name="pay_checknumber", nullable = false)//varchar clave principal
	private String checkNumber;


	/**
	 * 
	 */
	public PaymentsId() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param customerNumber
	 * @param checkNumber
	 */
	public PaymentsId(Customers customerNumber, @NotNull String checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}


	/**
	 * @return the customerNumber
	 */
	public Customers getCustomerNumber() {
		return customerNumber;
	}


	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Customers customerNumber) {
		this.customerNumber = customerNumber;
	}


	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}


	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PaymentsId [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + "]";
	}
	
	
	
}
