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

import com.laptrinhjava.utils.SessionUtil;

/**
 * Servlet Filter implementation class UserExistFilter
 */
@WebFilter(urlPatterns = {"/admin-home"})
public class UserExistFilter implements Filter {

	
    /**
     * Default constructor. 
     */

	/**
	 * @see Filter#destroy()
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("Di qua filter 1");
		if (SessionUtil.getValue(req, "USERMODEL") == null) {
			resp.sendRedirect(req.getContextPath()+"/login?action=login");
		}
		else chain.doFilter(request, response);
		
		
		
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	

	
}
