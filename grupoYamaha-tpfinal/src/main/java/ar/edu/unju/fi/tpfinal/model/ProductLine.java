package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTLINES")
public class ProductLine {
	
	@Id
	@Column(name="prodL_line")
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@NotBlank(message = "La celda no debe quedar vacia, ingrese una Categoria")
	private String productLinesName; 
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@NotBlank(message = "La celda no debe quedar vacia")
	@Column(name="prodL_textdescription")
	private String textDescription;
	@Size(max = 50,message = "debe ingresar maximo 50 caracteres")
	@NotBlank(message = "La celda no debe quedar vacia")
	@Column(name="prodL_htmldescription")
	private String htmlDescription;
	
	@Column(name="prodL_image")
	private String image;
	/**
	 * constructor de la clase ProductLine 
	 */
	public ProductLine() {
		// TODO  constructor de clase
	}
	
	/**
	 *Constructor de los atributos de la clase ProductLine
	 * @param productLinesName
	 * @param textDescription
	 * @param htmlDescription
	 * @param image
	 */
	public ProductLine(String productLinesName, String textDescription, String htmlDescription, String image) {
		super();//contstructor de atributos
		this.productLinesName = productLinesName;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}

	/**
	 * Método getter
	 * @return productLinesName, carga un valor tipo String
	 */
	public String getProductLinesName() {
		return productLinesName;
	}
	/**
	 * Método setter
	 * @param productLinesName, carga un valor tipo String
	 */
	public void setProductLinesName(String productLinesName) {
		this.productLinesName = productLinesName;
	}

	/**
	 * Método getter 
	 * @return textDescription, retorna un valor tipo String
	 */
	public String getTextDescription() {
		return textDescription;
	}
	/**
	 * Método setter 
	 * @param textDescription, carga un valor tipo String
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	/**
	 * Método getter 
	 * @return htmlDescription, retorna un valor tipo String
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}
	
	/**
	 * Método setter 
	 * @param htmlDescription, carga un valor tipo String
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	/**
	 * Método "getter" 
	 * @return image, retorna un valor tipo String
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Método "getter" 
	 * @param image, carga un valor tipo String
	 */
	public void setImage(String image) {
		this.image = image;
	}
}


