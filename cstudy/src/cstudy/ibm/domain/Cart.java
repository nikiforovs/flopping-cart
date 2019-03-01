package cstudy.ibm.domain;

public class Cart {
	private Long idCart;
	private Long idProduct;
	private Double productPrice;
	private int productQty;
	private Double total;
	
	public Cart() {
		
	}
	
	public Cart(Long idCart, Long idProduct, Double productPrice, int productQty, Double total) {
		this.idCart = idCart;
		this.idProduct = idProduct;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.total = productQty * productPrice;
		
	}
	public Long getIdCart() {
		return idCart;
	}
	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = productQty * productPrice;
	}


	
	
	
	
	
	

}
