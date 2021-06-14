package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails {
	
	//@Id
	//@Column(name = "Orderdetails_ordernumber")
	//private Long orderNumber;
	
	//@Column(name = "Orderdetails_productcode")
	//private Long productCode;
	
	
	@Column(name = "Orderdetails_quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "Orderdetails_priceeach")
	private double priceEach;
	
	@Column(name = "Orderdetails_orderlinenumber")
	private int orderLineNumber;//smallint
	

	@OneToOne
	@Autowired
	private Products products;

	@OneToOne
	@Autowired
	private Orders orders;
	/**
	 * 
	 */
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 * @param products
	 * @param orders
	 */
	public OrderDetails(int quantityOrdered, double priceEach, int orderLineNumber, Products products, Orders orders) {
		super();
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.products = products;
		this.orders = orders;
	}
	/**
	 * @return the quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	/**
	 * @return the priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}
	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}
	/**
	 * @return the orderLineNumber
	 */
	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}
	/**
	 * @return the orders
	 */
	public Orders getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrderDetails [quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber="
				+ orderLineNumber + ", products=" + products + ", orders=" + orders + "]";
	}
	

}
