package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PAYMENTS")
public class Payments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId //Indica que es integrada como clave primaria
	private PaymentsId id;
	
	@NotNull
	@Column(name="pay_paymentdate", nullable = false)
	private LocalDate paymentDate;
	
	@NotNull
	@Column(name="pay_amount",scale = 2, nullable = false)
	private double amount;
		
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param paymentDate
	 * @param amount
	 */
	public Payments(PaymentsId id, @NotNull LocalDate paymentDate, @NotNull double amount) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	/**
	 * @return the id
	 */
	public PaymentsId getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(PaymentsId id) {
		this.id = id;
	}


	/**
	 * @return the paymentDate
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Payments [id=" + id + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}


	
	
	
}
