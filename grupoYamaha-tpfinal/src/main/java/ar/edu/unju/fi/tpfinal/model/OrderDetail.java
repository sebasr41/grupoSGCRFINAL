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
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId //Indica que es integrada como clave primaria
	private OrderDetailId id;
	
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
	 /**
	  * Constructor orderDetail
	  */
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método "getter" 
	 * @return getId,retorna  el valor getId, de la clase OrderDetailId
	 */
	public OrderDetailId getId() {
		return id;
	}
	/**
	 * Método "setter"
	 * @param id, cara un id de la clase OrderDetailId
	 */
	public void setId(OrderDetailId id) {
		this.id = id;
	}
	/**
	 * Metodo "getter"
	 * @return quantityOrdered, retorna un valor tipo int
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	/**
	 * Método "setter"
	 * @param quantityOrdered, carga un valor tipo int
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	/**
	 * Método "getter"
	 * @return priceEach, muestra un valor tipo double
	 */
	public double getPriceEach() {
		return priceEach;
	}
	/**
	 * Método "setter"
	 * @param priceEach, carga un valor tipo double
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}
	/**
	 * Método "getter"
	 * @return orderLineNumber, muestra un valor tipo int
	 */
	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	/**
	 * Método "setter"
	 * @param orderLineNumber, carga valor tipo int 
	 */
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	/**
	 * Método "getter"
	 * @return serialVersionUID, retorna un valor tipo long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * constructor de los atributos de la clase :
	 * @param id
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 */
	public OrderDetail(OrderDetailId id, int quantityOrdered, double priceEach, int orderLineNumber) {
		super();
		this.id = id;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;

	}
	/**
	 * es Metodo para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}
	
}