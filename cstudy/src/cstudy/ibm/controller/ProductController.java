package cstudy.ibm.controller;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import cstudy.ibm.dao.ProductDao;
import cstudy.ibm.domain.Product;


@Path("/products")
public class ProductController {
	ProductDao productDao = new ProductDao();
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	
	@GET
	@Path("{idBrand}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findByBrand(@PathParam("idBrand") String idBrand) {
		return productDao.findByBrand(idBrand);
	}
	
	@GET
	@Path("{idBrand}/{idProduct}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product details(@PathParam("idProduct") String idProduct) {
		return productDao.details(idProduct);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Product product) {
		try {
			productDao.insert(product);
			String result = "Product added : " + product.getIdBrand() + " " + product.getProductName() + " " + product.getProductPrice();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Product product) {
		try {
			productDao.insert(product);
			String result = "Product updated : " + product.getIdBrand() + " " + product.getProductName() + " " + product.getProductPrice();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
//	@DELETE
//	@Path("/{idBrand}/{idProduct}")
//	public Response delete(Product product) {
//		try {
//			Long longIdProduct = Long.parseLong(idProduct);
//			productDao.delete(longIdProduct);
//			String result = "Product deleted";
//			return Response.status(200).entity(result).build();
//		} catch (Exception e) {
//			throw new WebApplicationException(e);
//		}
//	}

}
