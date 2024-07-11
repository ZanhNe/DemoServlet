package com.laptrinhjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.utils.SessionUtil;

/**
 * Servlet Filter implementation class UserRoleFilter
 */
@WebFilter(urlPatterns = {"/admin-home"})
public class UserRoleFilter implements Filter {

	
    /**
     * Default constructor. 
     */

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		UserModel user = (UserModel) SessionUtil.getValue(req, "USERMODEL");
		System.out.println("Di qua filter 2");
		if (!user.checkAdmin()) {
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}
		else chain.doFilter(request, response);
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
