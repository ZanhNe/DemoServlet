package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel user = new UserModel();
		try {
			user.setUserId(rs.getInt("UserID"));
			user.setUserName(rs.getString("Username"));
			user.setPassWord(rs.getString("Password"));
			user.setIsSeller(rs.getInt("isSeller"));
			user.setIsAdmin(rs.getInt("isAdmin"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

}
