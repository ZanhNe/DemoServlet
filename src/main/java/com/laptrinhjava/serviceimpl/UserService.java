package com.laptrinhjava.serviceimpl;

import com.laptrinhjava.dao.IUserDAO;
import com.laptrinhjava.daoimpl.UserDAO;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;

public class UserService implements IUserService{
	private IUserDAO userDao;
	
	public UserService() {
		userDao = new UserDAO();
	}

	@Override
	public UserModel findUser(UserModel user) {
		return userDao.findUser(user);
	}

	@Override
	public UserModel checkUserByNameAndPassword(UserModel user) {
		UserModel accountExist = findUser(user);
		if (accountExist != null && accountExist.checkPass(user)) 
			return accountExist;
		return null;
			
	}

	

	

}
