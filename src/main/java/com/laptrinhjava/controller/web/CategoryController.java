package com.laptrinhjava.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.pagination.Pagination;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.serviceimpl.CategoryService;
import com.laptrinhjava.serviceimpl.ProductService;
import com.laptrinhjava.utils.FormUtil;


@WebServlet(urlPatterns = {"/danh-muc"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = -1857212065144734586L;
	private IProductService productService;
	private ICategoryService categoryService;
    public CategoryController() {
		productService = new ProductService();
		categoryService = new CategoryService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagination paging = FormUtil.toModel(Pagination.class, req);
		
		List<ProductModel> list = productService.findProduct(paging);
		List<CategoryModel> listCt = categoryService.findAll();
		List<ProductModel> listLast = productService.findLast(1);
		req.setAttribute("cateId", req.getParameter("ct"));
		req.setAttribute("listLast", listLast);
		req.setAttribute("list", list);
		req.setAttribute("listCt", listCt);
		req.setAttribute("paging", paging);
		req.getRequestDispatcher("/views/web/category.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
