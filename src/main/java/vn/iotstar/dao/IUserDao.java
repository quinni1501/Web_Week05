package vn.iotstar.dao;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	// khai bao cac ham va thu tuc
	
	UserModel findByUserName(String username);
	
	
	 

}
