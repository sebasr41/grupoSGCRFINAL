package ar.edu.unju.fi.tpfinal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTLINES")
public class ProductLines {

	@Id
	@Column(name="productLinename")
	private String productLinesName;
	
	@Column(name="textdescription")
	private String textDescription;
	
	@Column(name="htmldescription")
	private String htmlDescription;
	
	
	private String image;
	

	/**
	 * 
	 */
	public ProductLines() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getProductLinesName() {
		return productLinesName;
	}


	public void setProductLinesName(String productLinesName) {
		this.productLinesName = productLinesName;
	}


	public String getTextDescription() {
		return textDescription;
	}


	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}


	public String getHtmlDescription() {
		return htmlDescription;
	}


	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public ProductLines(String productLinesName, String textDescription, String htmlDescription, String image) {
		super();
		this.productLinesName = productLinesName;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}


	@Override
	public String toString() {
		return "ProductLines [productLinesName=" + productLinesName + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + image + "]";
	}
}