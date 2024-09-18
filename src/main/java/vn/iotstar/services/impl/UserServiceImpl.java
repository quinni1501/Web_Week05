package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {

		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public static void main(String[] args) {

		try {
			
			IUserService userService = new UserServiceImpl();
			System.out.println(userService.login("quyen", "12345"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
