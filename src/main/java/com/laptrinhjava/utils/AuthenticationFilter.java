package com.laptrinhjava.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;
import com.laptrinhjava.serviceimpl.UserService;

public class AuthenticationFilter {
	private static IUserService userService = new UserService();
	private static UserModel userModel;
	private static AuthenticationFilter authenticationFilter = new AuthenticationFilter();
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("url");
	
	public static AuthenticationFilter of(UserModel user) {
		userModel = userService.checkUserByNameAndPassword(user);
		return authenticationFilter;
	}
	
	public String urlRedirect(HttpServletRequest request) {
		if (userModel != null) {
			SessionUtil.putValue(request, "USERMODEL", userModel);
			if (userModel.checkAdmin()) 
				return resourceBundle.getString("admin");
			else if (userModel.checkSeller())
				return resourceBundle.getString("seller");
			else return resourceBundle.getString("user");
		}
		return resourceBundle.getString("user_invalid");
	}
	

}
