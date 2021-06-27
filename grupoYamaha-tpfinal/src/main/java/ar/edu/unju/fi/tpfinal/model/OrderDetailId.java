package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Component
@Embeddable
public class OrderDetailId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "product_code")
	private Product productCode;
	
	@ManyToOne
	@JoinColumn(name ="order_number")
	private Order orderNumber;
	/**
	 * Constructor de clase OrderDetailId
	 */
	public OrderDetailId() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de atributos
	 * @param productCode
	 * @param orderNumber
	 */
	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}
	/**
	 * Método "getter",
	 * @return un valor de la  clase ProductCode
	 */
	public Product getProductCode() {
		return productCode;
	}
	/**
	 * Método "setter",
	 * @param productCode, "cargar un valor"  
	 * 
	 */
	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}
	/**
	 * Método "getter",
	 * @param order, "muestro un valor"
	 */
	public Order getOrderNumber() {
		return orderNumber;
	}
	/**
	 * Método "setter",
	 * @param orderNumber, "cargar un valor"  
	 */
	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}
	/** 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 *@Override es para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "OrderDetailsId [productCode=" + productCode + ", orderNumber=" + orderNumber + "]";
	}
	
	
	
}
