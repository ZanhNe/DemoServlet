package com.laptrinhjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.constant.SystemConstant;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.pagination.Pagination;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.service.IProductService;
import com.laptrinhjava.serviceimpl.CategoryService;
import com.laptrinhjava.serviceimpl.ProductService;
import com.laptrinhjava.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 991386665608221972L;
	private IProductService productService;
	private ICategoryService categoryService;

	public HomeController() {
		productService = new ProductService();
		categoryService = new CategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Pagination paging = null;
		String view = "/views/admin/dashboard.jsp";
		if (type != null) {
			if (type.equals(SystemConstant.LIST)) {
				paging = FormUtil.toModel(Pagination.class, req);
				if (req.getParameter("indexPage") != null) {
					List<ProductModel> list = productService.findProduct(paging);

					req.setAttribute("list", list);
					req.setAttribute("paging", paging);

				}
			} else if (type.equals(SystemConstant.EDIT)) {
				String productId = req.getParameter("productId");
				List<CategoryModel> listCate = categoryService.findAll();
				if (productId != null) {
					ProductModel productModel = productService.findOne(Integer.parseInt(productId));
					req.setAttribute("productModel", productModel);

				}
				req.setAttribute("listCate", listCate);
				view = "/views/admin/edit.jsp";

			}
		}
		if (paging != null && paging.getIndexPage() > paging.getTotalIndex()) {
			resp.sendRedirect(
					req.getContextPath() + "/admin-home?type=list&limit=6&indexPage=" + (paging.getIndexPage() - 1));
		} else
			req.getRequestDispatcher(view).forward(req, resp);
	}
}
