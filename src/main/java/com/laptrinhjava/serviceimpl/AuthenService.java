package com.laptrinhjava.serviceimpl;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.MessageModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IAuthenService;
import com.laptrinhjava.utils.AuthenticationFilter;
import com.laptrinhjava.utils.FormUtil;
import com.laptrinhjava.utils.MessageUtil;
import com.laptrinhjava.utils.SessionUtil;

public class AuthenService implements IAuthenService {
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	public void get(HttpServletRequest request, HttpServletResponse response, String action) {
		if (action != null) {
			if (action.equals("login"))
				login(request, response);
			else if (action.equals("logout"))
				logout(request, response);
		}

	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			MessageModel message = FormUtil.toModel(MessageModel.class, request);
			if (message.getMessage() != null && message.getAlert() != null)
				MessageUtil.of(resourceBundle.getString(message.getMessage()), message.getAlert())
						.buildMessage(request);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			SessionUtil.removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UserAuthentication(HttpServletRequest request, HttpServletResponse response, String action) {
		if (action != null) {
			if (action.equals("login")) {
				UserModel user = FormUtil.toModel(UserModel.class, request);
				String url = AuthenticationFilter.of(user).urlRedirect(request);
				try {
					response.sendRedirect(request.getContextPath() + url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
