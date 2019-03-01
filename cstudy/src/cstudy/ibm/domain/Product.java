package cstudy.ibm.domain;

public class Product {
	private Long idProduct;
	private Long idBrand;
	private String productName;
	private Double productPrice;
	private int productQty;

	public Product() {

	}

	public Product(Long idProduct, Long idBrand, String productName, Double productPrice, int productQty) {
		this.idProduct = idProduct;
		this.idBrand = idBrand;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productPrice = productPrice;
	}

	public Product(Long idBrand, String productName, Double productPrice) {
		super();
		this.idBrand = idBrand;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
}