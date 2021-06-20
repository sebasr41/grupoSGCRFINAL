package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Indica que es integrada como clave primaria
	private OrderDetailsId id;
	
	//@NotNull(message = "La casilla no debe quedar vacia, ingrese la cantidad del producto")
	@Column(name = "orderDet_quantityOrdered")
	private int quantityOrdered;
	
	//@NotNull(message = "La casilla no debe quedar vacia, ingrese Precio del producto")
	@Column(name = "orderDet_priceEach", scale = 2)
	private double priceEach;
	
	//@NotNull(message = "La casilla no debe quedar vacia")
	@Column(name = "orderDet_orderLineNumber")
	private int orderLineNumber;//smallint
	 
	public OrderDetails() {
		// TODO Auto-generated constructor stub
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
	public OrderDetails(OrderDetailsId id, int quantityOrdered, double priceEach, int orderLineNumber) {
		super();
		this.id = id;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;

	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}
	
}