package com.laptrinhjava.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAuthenService {
	
	void login(HttpServletRequest request, HttpServletResponse response);
	
	void logout(HttpServletRequest request, HttpServletResponse response);
	
	void register(HttpServletRequest request, HttpServletResponse response);
	
	void UserAuthentication(HttpServletRequest request, HttpServletResponse response, String action);
	
	void get(HttpServletRequest request, HttpServletResponse response, String action);
	
	
		


}
