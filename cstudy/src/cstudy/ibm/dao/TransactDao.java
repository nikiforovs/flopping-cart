package cstudy.ibm.dao;

import java.util.*;
import cstudy.ibm.db.DbConnect;
import cstudy.ibm.domain.Product;
import cstudy.ibm.domain.Transaction;
import java.sql.*;

public class TransactDao {
	DbConnect dbcon = new DbConnect();
	
	public List<Transaction> showTransaction() {
		dbcon.connect();
		List<Transaction> list= new ArrayList<Transaction>();
		try {
			dbcon.st = dbcon.con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dbcon.st = dbcon.con.createStatement();
			dbcon.rs = dbcon.st.executeQuery("SELECT * FROM TRANSACTION");
			
			while(dbcon.rs.next()) {
				Transaction transact = new Transaction();
				transact.setIdTransact(dbcon.rs.getLong("idCart"));
				transact.setIdCart(dbcon.rs.getLong("idBrand"));
				transact.setIdCustomer(dbcon.rs.getLong("idProduct"));
				transact.setTransactDate(dbcon.rs.getDate("transactDate"));
				list.add(transact);
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		dbcon.close();
		return list;
	}

}
