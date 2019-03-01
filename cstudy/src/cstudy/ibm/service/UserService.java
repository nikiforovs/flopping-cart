package cstudy.ibm.service;

import java.util.List;
import cstudy.ibm.dao.UserDao;
import cstudy.ibm.domain.User;

public class UserService {
	UserDao userDao = new UserDao();
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	public User profile(String idCustomer) {
		return userDao.profile(idCustomer);
	}
	public void insert(User user) {
		 userDao.insert(user);
	}

}
