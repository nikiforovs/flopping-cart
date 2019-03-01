package cstudy.ibm.domain;

import java.util.Date;

public class Transaction {
	private Long idTransact;
	private Long idCart;
	private Long idCustomer;
	private Date transactDate;
	
	public Transaction() {
		
	}
	
	public Transaction (Long idTransact, Long idCart, Long idCustomer, Date transactDate) {
		this.idTransact = idTransact;
		this.idCart = idCart;
		this.idCustomer = idCustomer;
		this.transactDate = transactDate;
	}
	
	public Long getIdTransact() {
		return idTransact;
	}
	public void setIdTransact(Long idTransact) {
		this.idTransact = idTransact;
	}
	public Long getIdCart() {
		return idCart;
	}
	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Date getTransactDate() {
		return transactDate;
	}
	public void setTransactDate(Date transactDate) {
		this.transactDate = transactDate;
	}

}
