package com.laptrinhjava.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.serviceimpl.ProductService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 5064200230694398464L;
	private IProductService productService;
	public HomeController() {
		productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> listBest = productService.findTop(4);
		List<ProductModel> listLast = productService.findLast(4);
		List<ProductModel> listTop = productService.findTop(1);
		req.setAttribute("listBest", listBest);
		req.setAttribute("listLast", listLast);
		req.setAttribute("listTop", listTop);
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}
}
