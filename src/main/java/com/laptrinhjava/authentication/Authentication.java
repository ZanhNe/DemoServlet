package com.laptrinhjava.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.service.IAuthenService;
import com.laptrinhjava.serviceimpl.AuthenService;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class Authentication extends HttpServlet {

	private static final long serialVersionUID = -5524011310757609376L;
	private IAuthenService authenService;

	public Authentication() {
		authenService = new AuthenService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		authenService.get(req, resp, action);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		authenService.UserAuthentication(req, resp, action);

	}

}
