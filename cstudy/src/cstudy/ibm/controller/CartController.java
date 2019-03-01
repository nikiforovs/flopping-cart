package cstudy.ibm.controller;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import cstudy.ibm.dao.CartDao;
import cstudy.ibm.domain.Cart;

@Path("/cart")
public class CartController {
	CartDao cartDao = new CartDao();
			
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Cart> showAllCarts() {
			return cartDao.showAllCarts();
		}
		
		@GET
		@Path("{idCart}")
		@Produces(MediaType.APPLICATION_JSON)
		public Cart viewCart(@PathParam("idCart") String idCart) {
			return cartDao.viewCart(idCart);
		}
		
//		@GET
//		@Path("{idBrand}/{idProduct}")
//		@Produces(MediaType.APPLICATION_JSON)
//		public Product details(@PathParam("idProduct") String idProduct) {
//			return productDao.details(idProduct);
//		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insert(Cart cart) {
			try {
				cartDao.insert(cart);
				String result = "Product added : " + cart.getIdProduct() + " " + cart.getProductPrice() + " " + cart.getProductQty() + " " + cart.getTotal();
				return Response.status(201).entity(result).build();
			} catch (Exception e) {
				throw new WebApplicationException(e);
			}
		}
		

}
