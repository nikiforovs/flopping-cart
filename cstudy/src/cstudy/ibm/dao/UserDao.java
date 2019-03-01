package cstudy.ibm.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import cstudy.ibm.db.*;
import cstudy.ibm.domain.*;

public class UserDao {
	DbConnect dbcon = new DbConnect();
	public List<User> findAllUsers() {
		dbcon.connect();
		List<User> list= new ArrayList<User>();
		try {
			dbcon.st = dbcon.con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dbcon.rs = dbcon.st.executeQuery("Select * from Users");
			
			while(dbcon.rs.next()) {
				User user = new User();
				user.setIdCustomer(dbcon.rs.getLong("idCustomer"));
				user.setFirstName(dbcon.rs.getString("firstName"));
				user.setLastName(dbcon.rs.getString("lastName"));
				user.setContactNumber(dbcon.rs.getLong("contactNumber"));
				user.setEmail(dbcon.rs.getString("email"));
				user.setPassword(dbcon.rs.getString("password"));
				user.setAddress1(dbcon.rs.getString("address1"));
				user.setAddress2(dbcon.rs.getString("address2"));
				user.setCity(dbcon.rs.getString("city"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbcon.close();
		return list;
	}
	public User profile(String idCustomer) {
		dbcon.connect();
		User user = new User();
		try {
			dbcon.st = dbcon.con.createStatement();
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM CUSTOMER WHERE IDCUSTOMER= "+ idCustomer);
			
			while(dbcon.rs.next()) {
				user.setIdCustomer(dbcon.rs.getLong("idCustomer"));
				user.setFirstName(dbcon.rs.getString("firstName"));
				user.setLastName(dbcon.rs.getString("lastName"));
				user.setContactNumber(dbcon.rs.getLong("contactNumber"));
				user.setEmail(dbcon.rs.getString("email"));
				user.setPassword(dbcon.rs.getString("password"));
				user.setAddress1(dbcon.rs.getString("address1"));
				user.setAddress2(dbcon.rs.getString("address2"));
				user.setCity(dbcon.rs.getString("city"));
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		dbcon.close();
		return user;
	}
	
	public void insert(User user) {
		dbcon.connect();
		try {
			String sql = "INSERT INTO CUSTOMER(firstName,lastName,contactNumber, email, password, address1, address2, city)" 
							+  " VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = dbcon.con.prepareStatement(sql);
			
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setLong(3,user.getContactNumber());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			pst.setString(6, user.getAddress1());
			pst.setString(7, user.getAddress2());
			pst.setString(8, user.getCity());
			
			pst.executeUpdate();
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		dbcon.close();
	}

}
