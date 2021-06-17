package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PaymentsId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "customer_number")
	private Customers customerNumber;

	
	public PaymentsId() {
		// TODO Auto-generated constructor stub
	}

	public PaymentsId(Customers customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}


	public Customers getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(Customers customerNumber) {
		this.customerNumber = customerNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PaymentsId [customerNumber=" + customerNumber + "]";
	}

	
	
	
}
