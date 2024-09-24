package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {

	@Override
	public UserModel findByUserName(String username) {

		String sql = "select * from Table_1 where username =?";

		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // truyen tham so
			ResultSet rs = ps.executeQuery(); // thuc thi phat bieu prepare roi dua kq vao resultset
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

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO Table_1 (username, email, password, fullname, image, phone, roleid, createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImage());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreateddate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkExistEmail(String email) {

		boolean duplicate = false;
		String query = "select * from Table_1 where email = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {

		boolean duplicate = false;
		String query = "select * from Table_1 where username = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPassword(UserModel user) {
		String sql = "UPDATE Table_1 SET password = ? WHERE username = ?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword()); 
			ps.setString(2, user.getUsername()); 
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * try { IUserDao userDao = new UserDaoImpl();
	 * System.out.println(userDao.findByUserName("quyen")); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

}