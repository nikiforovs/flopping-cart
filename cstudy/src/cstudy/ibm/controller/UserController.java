package cstudy.ibm.controller;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import cstudy.ibm.dao.UserDao;
import cstudy.ibm.domain.User;

@Path("/user") 
public class UserController {
	UserDao userDao = new UserDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> details() {
		return userDao.findAllUsers();
	}
	@GET
	@Path("{idCustomer}")
	@Produces(MediaType.APPLICATION_JSON)
	public User profile(@PathParam("idCustomer") String idCustomer) {
		return userDao.profile(idCustomer);
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(User user) {
		try {
			userDao.insert(user);
			String result = "User saved : " + user.getFirstName() + " " + user.getLastName() + " " + user.getContactNumber()
							+ " " + user.getEmail() + " " + user.getPassword() + " " + user.getAddress1()
							+ " " + user.getAddress2() + " " + user.getCity();
			return Response.status(201).entity(result).build();
			} 
		catch (Exception e) {
			throw new WebApplicationException(e);
			}
		}
}
