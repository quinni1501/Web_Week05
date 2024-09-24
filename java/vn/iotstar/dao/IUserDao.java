package vn.iotstar.dao;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	// khai bao cac ham va thu tuc
	
	UserModel findByUserName(String username);
	void insert(UserModel user);
	
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void resetPassword (UserModel user);

	
	 

}
