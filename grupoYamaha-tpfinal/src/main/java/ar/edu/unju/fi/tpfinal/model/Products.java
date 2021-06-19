package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
public class Products {
	
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
	@NotNull(message = "La casilla no debe quedar vacia, Ingrese nombre de producto")
	@Column(name = "produc_name")
	private String productName;
	
	@Size(max=10, message="El texto debe ser inferior o igual a 10 caracteres")
	@NotNull(message = "La casilla no debe quedar vacia, ingrese escala de producto")
	@Column(name = "produc_scale")
	private String productScale;
	
	@Size(max=50, message="El texto debe ser inferior o igual a 50 caracteres")
	@NotNull(message = "La casilla no debe quedar vacia, ingrese Empresa proveniente del producto")
	@Column(name = "produc_vendedor")
	private String productVendor;
	
	@NotNull(message = "La casilla no debe quedar vacia, ingrese una descripción del producto")
	@Column(name = "produc_description")
	private String productDescription;//text
	
	@NotNull(message = "La casilla no debe quedar vacia, ingrese STOCK producto")
	@Column(name = "produc_quantityinStock")
	private int quantityInStock;//smallint
	
	@NotNull(message = "La casilla no debe quedar vacia, ingrese PRECIO del producto")
	@Column(name = "produc_buyprice")
	private double buyPrice;
	
	@NotNull(message = "La casilla no debe quedar vacia, ingrese Precio sugerido por el fabricante (MSRP)")
	@Column(name = "produc_msrp")
	private double MSRP;
	
	
	@ManyToOne
	@Autowired
	private ProductLines productLines;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}
	

	public Products(String productCode, String productName, String productScale, String productVendor,
			String productDescription, int quantityInStock, double buyPrice, double mSRP, ProductLines productLines) {
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



	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductScale() {
		return productScale;
	}



	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}



	public String getProductVendor() {
		return productVendor;
	}



	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public int getQuantityInStock() {
		return quantityInStock;
	}



	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}



	public double getBuyPrice() {
		return buyPrice;
	}



	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}



	public double getMSRP() {
		return MSRP;
	}



	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}


	public ProductLines getProductLines() {
		return productLines;
	}

	public void setProductLines(ProductLines productLines) {
		this.productLines = productLines;
	}



	@Override
	public String toString() {
		return "Products [productCode=" + productCode + ", productName=" + productName + ", productScale="
				+ productScale + ", productVendor=" + productVendor + ", productDescription=" + productDescription
				+ ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP=" + MSRP
				+ ", productLines=" + productLines + "]";
	}

	


}
