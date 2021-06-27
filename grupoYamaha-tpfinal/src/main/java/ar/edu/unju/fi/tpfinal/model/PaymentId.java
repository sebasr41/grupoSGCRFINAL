package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
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
public class PaymentId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "customer_number")
	private Customer customerNumber;
	
	@Column(name="pay_checknumber")//varchar clave principal
	private String checkNumber;
	/**
	 * Constructor PaymentId
	 */
	public PaymentId() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de los atributos de la clase PymentId
	 * @param customerNumber
	 * @param checkNumber
	 */
	public PaymentId(Customer customerNumber, String checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}


	/**
	 * Método "getter"
	 * @return customerNumber, de clase Customer
	 */
	public Customer getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Metodo setter
	 * @param customerNumber, de la clase Customer
	 */
	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Método "getter"
	 * @return serialVersionUID un valor tipo long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Método "getter"
	 * @return checkNumber, retorna un valor tipo string
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * Método "setter"
	 * @param checkNumber, cargaun valor tipo string
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	/**
	 * es Metodo para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "PaymentsId [customerNumber=" + customerNumber + "]";
	}

}
