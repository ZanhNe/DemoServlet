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

@WebServlet(urlPatterns = {"/danh-muc/san-pham"})
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = -2210857557550683474L;
	private IProductService productService;
	public ProductDetailController() {
		productService = new ProductService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> list = productService.findProductByProductId(Integer.parseInt(req.getParameter("sp")));
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/web/productdetail.jsp").forward(req, resp);
	}
}
