package cstudy.ibm.service;

import java.util.List;

import cstudy.ibm.dao.ProductDao;
import cstudy.ibm.domain.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	
	public List<Product> findByBrand(String idBrand) {
		return productDao.findByBrand(idBrand);
	}
	
	public Product details(String idProduct) {
		return productDao.details(idProduct);
	}
	
	public void insert(Product product) {
		productDao.insert(product);
	}
}
