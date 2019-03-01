package cstudy.ibm.domain;

public class CustomerPayment {
	private Long idCustomerP;
	private String cardType;
	private Long cardNumber;
	private int cardSec;
	
	public CustomerPayment() {
		
	}
	
	public CustomerPayment(Long idCustomerP, String cardType, Long cardNumber, int cardSec) {
		this.idCustomerP = idCustomerP;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardSec = cardSec;		
	}
	
	public Long getIdCustomerP() {
		return idCustomerP;
	}
	public void setIdCustomerP(Long idCustomerP) {
		this.idCustomerP = idCustomerP;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardSec() {
		return cardSec;
	}
	public void setCardSec(int cardSec) {
		this.cardSec = cardSec;
	}
	
	
	
	
	

}
