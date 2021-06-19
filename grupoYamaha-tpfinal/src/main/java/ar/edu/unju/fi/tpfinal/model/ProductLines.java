package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="PRODUCTLINES")
public class ProductLines {
	
	@Id
	@NotNull(message = "La celda no debe quedar vacia, igrese un Nombre de la categoria, inferior a 50 caracteres")
	@Column(name="prodL_line",length = 50)
	private String productLinesName; 
	
	@Size(max = 4000, message = "Ingrese un texto debe inferiro a 4000 caracteres")
	@Column(name="prodL_textdescription")
	private String textDescription;
	
	@Column(name="prodL_htmldescription")
	private String htmlDescription;
	
	@Column(name="prodL_image")
	private String image;
	
	public ProductLines() {
		// TODO Auto-generated constructor stub
	}

	public ProductLines(String productLinesName, String textDescription, String htmlDescription, String image) {
		super();
		this.productLinesName = productLinesName;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
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
}


