package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpfinal.generator.StringPrefixedSequenceIdGenerator;

@Component
@Entity
@Table(name="PAYMENTS")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@EmbeddedId //Indica que es integrada como clave primaria
	private PaymentId id;
	
	@Column(name="pay_paymentdate")
	private LocalDate paymentDate;
	
	@Column(name="pay_amount")
	private double amount;
		/**
		*Constructor de la clase Payments
		*/
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de los atributos de la clase Payments
	 * @param id
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(PaymentId id, LocalDate paymentDate, double amount) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	/**
	 * Método "getter" 
	 * @return getId, de la clase PaymentId 
	 */
	public PaymentId getId() {
		return id;
	}
	
	
	/**
	 * Método "setter" 
	 * @param getId, se carda desde la clase PaymentId
	 */
	public void setId(PaymentId id) {
		this.id = id;
	}


	/**
	 * Método "getter" 
	 * @return paymentDate, muestra un valor LocalDate
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	/**
	 * Método "setter"
	 * @param paymentDate, carga un valor LocalDate 
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * Método "getter"
	 * @return amount, retorna un valor tipo double
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Método "setter"
	 * @param amount, carga un valor tipo double
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * Método "getter"
	 * @return  serialVersionUID, de tipo long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * es Metodo para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "Payments [id=" + id + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}
}
