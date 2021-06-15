package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderNumber;	

	@Column(name = "Orderdetails_quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "Orderdetails_priceeach")
	private double priceEach;
	
	@Column(name = "Orderdetails_orderlinenumber")
	private int orderLineNumber;//smallint
	

	@OneToOne
	private Products products;


	@OneToOne(mappedBy = "orderDetails")
	private Orders orders;
	/**
	 * 
	 */
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public OrderDetails(Long orderNumber, int quantityOrdered, double priceEach, int orderLineNumber, Products products, Orders orders) {
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.products = products;
		this.orders = orders;
	}
	

	public Long getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}



	public int getQuantityOrdered() {
		return this.quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return this.priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return this.orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "{" +
			" orderNumber='" + getOrderNumber() + "'"  + "'" +
			", quantityOrdered='" + getQuantityOrdered() + "'" +
			", priceEach='" + getPriceEach() + "'" +
			", orderLineNumber='" + getOrderLineNumber() + "'" +
			", products='" + getProducts() + "'" +
			", orders='" + getOrders() + "'" +
			"}";
	}

}
