package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Indica que es integrada como clave primaria
	private OrderDetailsId id;
	
	@Min(value = 1,message = "El stock debe ser igual o mayor a 1")
	@Max(value = 1000,message = "El stock debe ser igual o menor a 1000 productos")	
	@Column(name = "orderDet_quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "orderDet_priceEach", scale = 2)
	private double priceEach;

	@Min(value = 1,message = "El stock debe ser igual o mayor a 1")
	@Max(value = 18,message = "El stock debe ser igual o menor a 18 productos")
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