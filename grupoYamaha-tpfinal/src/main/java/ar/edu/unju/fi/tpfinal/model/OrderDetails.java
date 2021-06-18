package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Indica que es integrada como clave primaria
	private OrderDetailsId id;
	
	
	private int quantityOrdered;
	

	private double priceEach;
	
	

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