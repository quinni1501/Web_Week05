package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao{

	@Override
	public UserModel findByUserName(String username) {
		
		String sql = "select * from Table_1 where username =?";
		
		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);     // truyen tham so
			ResultSet rs = ps.executeQuery();   //thuc thi phat bieu prepare roi dua kq vao resultset
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreateddate(rs.getDate("createddate"));
				
				return user;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	public static void main(String[] args) {
		
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUserName("quyen"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	

}
