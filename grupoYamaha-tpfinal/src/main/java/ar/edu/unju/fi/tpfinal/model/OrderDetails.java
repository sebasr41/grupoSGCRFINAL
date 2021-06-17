package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Indica que es integrada como clave primaria
	private OrderDetailsId id;
	
	@NotNull
	@Column(name = "OrderDet_quantityOrdered", nullable = false)
	private int quantityOrdered;
	
	@NotNull
	@Column(name = "OrderDet_priceeach", nullable = false)
	private double priceEach;
	
	@NotNull
	@Column(name = "OrderDet_orderlinenumber", nullable = false)
	private int orderLineNumber;//smallint
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetails(OrderDetailsId id, int quantityOrdered, double priceEach, int orderLineNumber) {
		super();
		this.id = id;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public OrderDetailsId getId() {
		return id;
	}

	public void setId(OrderDetailsId id) {
		this.id = id;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
	
	
}
