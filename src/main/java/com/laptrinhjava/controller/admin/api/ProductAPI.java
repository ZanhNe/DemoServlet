package com.laptrinhjava.controller.admin.api;

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
import com.laptrinhjava.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-product" })
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = -8864547654113526005L;
	private IProductService productService;

	public ProductAPI() {
		productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel productModel = HttpUtil.toModel(req.getReader(), ProductModel.class);
		ProductModel pm = productService.save(productModel);
		HttpUtil.toJson(resp.getOutputStream(), pm);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel newProductModel = HttpUtil.toModel(req.getReader(), ProductModel.class);
		ProductModel resultUpdate = productService.update(newProductModel);
		HttpUtil.toJson(resp.getOutputStream(), resultUpdate);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		List<ProductModel> listProduct = HttpUtil.toListModel(req.getReader(), ProductModel.class);
		System.out.println(listProduct);
		productService.delete(listProduct);
		System.out.println("Vao delete");
		HttpUtil.toJson(resp.getOutputStream(), "{}");

	}

}
