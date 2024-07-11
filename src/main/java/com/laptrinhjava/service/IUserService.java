package com.laptrinhjava.service;

import com.laptrinhjava.model.UserModel;

public interface IUserService {
	UserModel findUser(UserModel user);
	
	UserModel checkUserByNameAndPassword(UserModel user);
	
	
	
	

}
