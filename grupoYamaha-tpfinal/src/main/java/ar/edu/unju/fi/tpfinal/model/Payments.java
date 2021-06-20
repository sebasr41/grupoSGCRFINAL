package ar.edu.unju.fi.tpfinal.model;

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
public class Payments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@EmbeddedId //Indica que es integrada como clave primaria
	private PaymentsId id;
	
	
	
	
	@Column(name="pay_paymentdate")
	private LocalDate paymentDate;
	
	@Column(name="pay_amount")
	private double amount;
		
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Payments(PaymentsId id, LocalDate paymentDate, double amount) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}





	public PaymentsId getId() {
		return id;
	}

	public void setId(PaymentsId id) {
		this.id = id;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Payments [id=" + id + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}

	
	
	
}
