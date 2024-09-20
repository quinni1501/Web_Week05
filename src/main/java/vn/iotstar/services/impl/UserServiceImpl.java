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

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        // Create a new UserModel instance with the provided details
        UserModel newUser = new UserModel();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUsername(username);
        newUser.setFullname(fullname);
        newUser.setPhone(phone);
        newUser.setCreateddate(date);
        newUser.setRoleid(1); // Assuming default role ID is 1

        userDao.insert(newUser); // Insert the new user into the database
        return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);

	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

}
