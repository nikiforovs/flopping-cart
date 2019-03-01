package cstudy.ibm.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cstudy.ibm.db.DbConnect;
import cstudy.ibm.domain.Cart;

public class CartDao {
	DbConnect dbcon = new DbConnect();
	
	public List<Cart> showAllCarts() {
		dbcon.connect();
		List<Cart> list= new ArrayList<Cart>();
		try {
			dbcon.st = dbcon.con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM PRODUCT");
			
			while(dbcon.rs.next()) {
				Cart cart = new Cart();
				cart.setIdProduct(dbcon.rs.getLong("idProduct"));
				cart.setProductPrice(dbcon.rs.getDouble("productPrice"));
				cart.setProductQty(dbcon.rs.getInt("productQty"));
				cart.setTotal(dbcon.rs.getDouble("total"));
				list.add(cart);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		dbcon.close();
		return list;
	}
	
	public Cart viewCart(String idCart) {
		dbcon.connect();
		Cart cart = new Cart();
		try {
			dbcon.st = dbcon.con.createStatement();
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM CART WHERE IDCART= "+ idCart);
			
			while(dbcon.rs.next()) {
				cart.setIdCart(dbcon.rs.getLong("idCart"));
				cart.setIdProduct(dbcon.rs.getLong("idProduct"));
				cart.setProductPrice(dbcon.rs.getDouble("productPrice"));
				cart.setProductQty(dbcon.rs.getInt("productQty"));
				cart.setTotal(dbcon.rs.getDouble("total"));
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		dbcon.close();
		return cart;
	}
	
	public void insert(Cart cart) {
		dbcon.connect();
		try {
			String sql = "INSERT INTO CART(idProduct,productPrice, productQuantity)" 
							+  " VALUES(?, ?, ?)";
			PreparedStatement pst = dbcon.con.prepareStatement(sql);
			cart.setTotal(cart.getTotal());
			
			pst.setLong(1, cart.getIdProduct());
			pst.setDouble(2, cart.getProductPrice());
			pst.setInt(3, cart.getProductQty());
			pst.setDouble(4, cart.getTotal());

			pst.executeUpdate();
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		dbcon.close();
	}

}
