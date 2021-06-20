package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpfinal.generator.StringPrefixedSequenceIdGenerator;
@Component
@Embeddable
public class PaymentsId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "customer_number")
	private Customers customerNumber;

	@Column(name="pay_checknumber")//varchar clave principal
	private String checkNumber;
	
	public PaymentsId() {
		// TODO Auto-generated constructor stub
	}

	

	public PaymentsId(Customers customerNumber, String checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
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


	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public String toString() {
		return "PaymentsId [customerNumber=" + customerNumber + "]";
	}

	
	
	
}
