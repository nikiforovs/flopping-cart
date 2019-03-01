package cstudy.ibm.service;

import cstudy.ibm.domain.Cart;
import cstudy.ibm.dao.CartDao;

public class CartService {
	CartDao cartDao = new CartDao();
	
	public Cart viewCart(String idCart) {
		return cartDao.viewCart(idCart);
	}

}
