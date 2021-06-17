package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PAYMENTS")
public class Payments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId //Indica que es integrada como clave primaria
	private PaymentsId id;
	
	@NotNull
	@Id
	@Column(name="pay_checknumber", nullable = false)//varchar clave principal
	private String checkNumber;
	
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

	public Payments(PaymentsId id, @NotNull String checkNumber, @NotNull LocalDate paymentDate,
			@NotNull double amount) {
		super();
		this.id = id;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public PaymentsId getId() {
		return id;
	}

	public void setId(PaymentsId id) {
		this.id = id;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
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
		return "Payments [id=" + id + ", checkNumber=" + checkNumber + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}

	
	
	
}
