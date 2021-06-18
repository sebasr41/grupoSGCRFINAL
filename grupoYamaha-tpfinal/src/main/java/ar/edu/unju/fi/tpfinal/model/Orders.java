package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="ORDERS")
public class Orders {
	
	@Id
	@Column(name="orders_number")
	private Long orderNumber; //la profe lo puso Integer
	
	@NotNull
	@Column(name="orders_orderdate", nullable = false)
	private LocalDate orderDate;
	
	@NotNull
	@Column(name="orders_requiredDate", nullable = false)
	private LocalDate requiredDate;
	
	@Column(name="orders_shippeddate")
	private LocalDate shippedDate;
	
	@NotNull
	@Column(name="orders_status",length = 15, nullable = false)
	private String status;
	
	@Column(name="orders_comments")
	private String comments;	
	
	@NotNull
	@ManyToOne
	@Autowired
	@JoinColumn(name="cust_number", nullable = false)
	private Customers customers;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Long orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate,
			String status, String comments, Customers customers) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customers = customers;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customers="
				+ customers + "]";
	}

}
