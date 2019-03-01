package cstudy.ibm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/cstudy", "SA", "");			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Product");
			
			while(rs.next()) {
				System.out.println(rs.getString("productName")+ ", " + rs.getString("productPrice"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}