package com.laptrinhjava.daoimpl;

import java.util.List;

import com.laptrinhjava.dao.IUserDAO;
import com.laptrinhjava.mapper.UserMapper;
import com.laptrinhjava.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findUser(UserModel user) {
		String sql = "select * from users where username = ?";
		List<UserModel> list = query(sql, new UserMapper(), user.getUserName());
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public int save(UserModel user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserModel user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(UserModel user) {
		// TODO Auto-generated method stub
		
	}

}
