package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orders_number")
	private Long orderNumber; //la profe lo puso Integer
	
	@Column(name="orders_orderdate", nullable = false)
	private LocalDate orderDate;
	
	@Column(name="orders_requiredDate", nullable = false)
	private LocalDate requiredDate;
	
	@Column(name="orders_shippeddate")
	private LocalDate shippedDate;
	
	@Column(name="orders_status",length = 15, nullable = false)
	private String status;
	
	@Column(name="orders_comments")
	private String comments;	
	
	@ManyToOne
	@Autowired
	@JoinColumn(name="cust_number", nullable = false)
	private Customer customers;
	/**
	 * COnstructor de la clase Order
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de los atributos Order
	 * @param orderNumber
	 * @param orderDate
	 * @param requiredDate
	 * @param shippedDate
	 * @param status
	 * @param comments
	 * @param customers
	 */
	public Order(Long orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate,
			String status, String comments,Customer customers) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customers = customers;
	}

	/**
	 * Método "getter" 
	 * @return orderNumber, muestra un valor tipo Long
	 */
	public Long getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Método "setter" 
	 * @param orderNumber, carga un valor tipo Long
	 */
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Método "getter" 
	 * @return orderDate, muestra un valor tipo LocalDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * Método "setter" 
	 * @param orderDate, carga un valor tipo LocalDate
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Método "getter" 
	 * @return requiredDate, muestra  un valor tipo LocalDate
	 */
	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	/**
	 * Método "setter" 
	 * @param requiredDate, carga un valor tipo LocalDate
	 */
	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * Método "getter" 
	 * @return shippedDate, muestra un valor de tipo LocalDate
	 */
	public LocalDate getShippedDate() {
		return shippedDate;
	}

	/**
	 * Método "setter" 
	 * @param shippedDate, carga un valor de  tipo LocalDate
	 */
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * Método "getter" 
	 * @return status, muestra un vlaor tipo String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Método "setter" 
	 * @param comments, carga un valor de  tipo String
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Método "getter" 
	 * @return comments, mostrar un valor de  tipo String
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Método "setter" 
	 * @param comments, cargga un valor de  tipo String
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


	/**
	 * Método "getter"
	 * @return Customer, mostramos un valor de la clase Customer
	 */
	public Customer getCustomers() {
		return customers;
	}
	
	/**
	 * 
	 * Método "getter"
	 * @param customers, carga un valor de la clase Customer
	 */
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	/**
	 * es Metodo para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customers="
				+ customers + "]";
	}

	
}
