package cstudy.ibm.db;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
	public Connection con;
	 Statement st;
	 ResultSet rs;
	
	public void connect() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		try { 
			 con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/cstudy", "SA", ""); 
			 st = con.createStatement(); 
			 
			 System.out.println("Connection created successfuly"); 
			 }
		 catch (SQLException e) { 
			 e.printStackTrace(); 
			 } 
		 }
	
	public void close() { 
		try { 
			con.close(); 
			} 
		catch (SQLException e) { 
			e.printStackTrace(); 
			} 
	    }


	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}