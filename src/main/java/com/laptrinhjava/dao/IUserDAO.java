package com.laptrinhjava.dao;

import com.laptrinhjava.model.UserModel;

public interface IUserDAO {
	
	UserModel findUser(UserModel user);
	int save(UserModel user);
	int update(UserModel user);
	void delete(UserModel user);

}
