package cstudy.ibm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cstudy.ibm.domain.*;
import cstudy.ibm.db.*;

public class ProductDao{
	DbConnect dbcon = new DbConnect();
	
	public List<Product> findAllProducts() {
		dbcon.connect();
		List<Product> list= new ArrayList<Product>();
		try {
			dbcon.st = dbcon.con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM PRODUCT");
			
			while(dbcon.rs.next()) {
				Product product = new Product();
				product.setIdProduct(dbcon.rs.getLong("idProduct"));
				product.setIdBrand(dbcon.rs.getLong("idBrand"));
				product.setProductName(dbcon.rs.getString("productName"));
				product.setProductPrice(dbcon.rs.getDouble("productPrice"));
				list.add(product);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		dbcon.close();
		return list;
	}
	
	public List<Product> findByBrand(String idBrand) {
		dbcon.connect();
		List<Product> list = new ArrayList<Product>();
		try {
			dbcon.st = dbcon.con.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM PRODUCT WHERE idBrand = " +idBrand);
			
			while(dbcon.rs.next()) {
				Product product = new Product();
				product.setIdProduct(dbcon.rs.getLong("idProduct"));
				product.setIdBrand(dbcon.rs.getLong("idBrand"));
				product.setProductName(dbcon.rs.getString("productName"));
				product.setProductPrice(dbcon.rs.getDouble("productPrice"));
				list.add(product);
				}
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		dbcon.close();
		return list;
	}

	public Product details(String idProduct) {
		dbcon.connect();
		Product product = new Product();
		try {
			dbcon.st = dbcon.con.createStatement();
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM PRODUCT WHERE idProduct = "+ idProduct);
			
			while(dbcon.rs.next()) {
				product.setIdProduct(dbcon.rs.getLong("idProduct"));
				product.setIdBrand(dbcon.rs.getLong("idBrand"));
				product.setProductName(dbcon.rs.getString("productName"));
				product.setProductPrice(dbcon.rs.getDouble("productPrice"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			}
	dbcon.close();
	return product;
	}
	
	public void insert(Product product) {
		dbcon.connect();
		try {
			String sql = "INSERT INTO PRODUCT(idBrand,productName, productPrice)" 
							+  " VALUES (?,?,?)";
			PreparedStatement pst = dbcon.con.prepareStatement(sql);
			
			pst.setLong(1, product.getIdBrand());
			pst.setString(2, product.getProductName());
			pst.setDouble(3,product.getProductPrice());
			
			pst.executeUpdate();
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		dbcon.close();
	}
	
	
}
