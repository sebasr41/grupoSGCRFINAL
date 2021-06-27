package ar.edu.unju.fi.tpfinal.model;
/**
 * @author RCGS
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpfinal.generator.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @GenericGenerator(name = "prod_seq",
    strategy = "ar.edu.unju.fi.tpfinal.generator.StringPrefixedSequenceIdGenerator",
    parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "S10_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String productCode;//es varchar
	@Size(max=70, message = "El text debe ser inferior o igual a 70 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia, Ingrese nombre de producto")
	@Column(name = "produc_name")
	private String productName;
	
	@Size(max=10, message="El texto debe ser inferior o igual a 10 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia, ingrese escala de producto")
	@Column(name = "produc_scale")
	private String productScale;
	
	@Size(max=50, message="El texto debe ser inferior o igual a 50 caracteres")
	@NotBlank(message = "La casilla no debe quedar vacia, ingrese Empresa proveniente del producto")
	@Column(name = "produc_vendedor")
	private String productVendor;
	
	@NotBlank(message = "La casilla no debe quedar vacia")
	@Column(name = "produc_description")
	private String productDescription;//text
		
	@Min(value = 1, message = "La casilla no debe quedar vacia, su valor puede ir desde 0 como minimo")
	@Column(name = "produc_quantityinStock")
	private int quantityInStock;//smallint

	@Min(value = 1, message = "La casilla no debe quedar vacia, su valor puede ir desde 0 como minimo")
	@Column(name = "produc_buyprice",scale = 2)
	private double buyPrice;
	
	
	@DecimalMin(value = "0.1",message =  "La casilla no debe quedar vacia, ingrese algun Precio sugerido por el fabricante (MSRP), superior a 1")
	@Column(name = "produc_msrp", scale = 2)
	private double MSRP;
	
	
	@ManyToOne
	@Autowired
	private ProductLine productLines;
	/**
	 * cosntructor de la clase
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de Atributos
	 * @param productCode
	 * @param productName
	 * @param productScale
	 * @param productVendor
	 * @param productDescription
	 * @param quantityInStock
	 * @param buyPrice
	 * @param mSRP
	 * @param productLines
	 */

	public Product(String productCode, String productName, String productScale, String productVendor,
			String productDescription, int quantityInStock, double buyPrice, double mSRP, ProductLine productLines) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
		this.productLines = productLines;
	}


	/**
 	 * Método "getter"
	 * @return productCode, retorna un valor tipo String
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * Método "setter"
	 * @param productCode carga un valor tipo String
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * Método "getter"
	 * @return productName, retorna un valor tipo String 
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * Método "setter"
	 * @param productName, carga un valor tipo String
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Método "getter"
	 * @return productScale, retorna un valor tipo String
	 */
	public String getProductScale() {
		return productScale;
	}


	/**
	 * Método "setter"
	 * @param productScale,  carga  un valor tipo String
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}


	/**
	 * Método "getter"
	 * @return productVendor, retorna un valor tipo String
	 */
	public String getProductVendor() {
		return productVendor;
	}


	/**
	 * Método "setter"
	 * @param productVendor , carga  un valor tipo String
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}


	/**
	 * Método "getter"
	 * @return productDescription, retorna un valor tipo string
	 */
	public String getProductDescription() {
		return productDescription;
	}


	/**
	 * Método "setter"
	 * @param productDescription, carga un valor tipo string
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	/**
	 * Método "getter"
	 * @return quantityInStock, retorna un valor tipo int
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}


	/**
	 * Método "setter"
	 * @param quantityInStock, carga un valor tipo int
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	/**
	 * Método "getter"
	 * @return, muestra un valro tipo double 
	 */
	public double getBuyPrice() {
		return buyPrice;
	}


	/**
	 * Método "setter"
	 * @param buyPrice, carga un valro tipo double
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}


	/**
	 * Método "getter"
	 * @return MSRP, un valor tipo double
	 */
	public double getMSRP() {
		return MSRP;
	}


	/**
	 * Método "setter"
	 * @param mSRP, carga un valor tipo double
	 */
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	/**
	 * Método "getter"
	 * @return productLines, mostrar de la clase productLines
	 */
	public ProductLine getProductLines() {
		return productLines;
	}
	/**
	 * Método "setter"
	 * @param productLines, carga un valor productLines
	 */
	public void setProductLines(ProductLine productLines) {
		this.productLines = productLines;
	}


	/**
	 * es Metodo para que pueda sobreescribiendo un método de alguna clase padre
	 */
	@Override
	public String toString() {
		return "Products [productCode=" + productCode + ", productName=" + productName + ", productScale="
				+ productScale + ", productVendor=" + productVendor + ", productDescription=" + productDescription
				+ ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP=" + MSRP
				+ ", productLines=" + productLines + "]";
	}

	


}
