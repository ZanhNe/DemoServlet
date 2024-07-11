package com.laptrinhjava.serviceimpl;

import java.util.List;

import com.laptrinhjava.dao.IProductDAO;
import com.laptrinhjava.daoimpl.ProductDAO;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.pagination.Pagination;
import com.laptrinhjava.service.IProductService;

public class ProductService implements IProductService {
	private IProductDAO productDao;

	public ProductService() {
		productDao = new ProductDAO();
	}

	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<ProductModel> findLast(int id) {
		return productDao.findLast(id);
	}

	@Override
	public List<ProductModel> findTop(int id) {
		return productDao.findTop(id);
	}

	@Override
	public List<ProductModel> findProductCateId(int categoryId) {
		return productDao.findProduct(categoryId, new CategoryModel());
	}

	@Override
	public List<ProductModel> findProductByProductId(int productId) {
		return productDao.findProduct(productId, new ProductModel());
	}

	@Override
	public List<ProductModel> getProductByCate(String id) {
		if (id == null)
			return findAll();
		int cateId = Integer.parseInt(id);
		return findProductCateId(cateId);
	}

	@Override
	public List<ProductModel> findProductByName(String name) {
		return productDao.findProduct(name, new ProductModel());
	}

	@Override
	public ProductModel save(ProductModel pm) {
		int id = productDao.save(pm);
		return productDao.findOne(id, new ProductModel());
	}

	@Override
	public ProductModel findOne(int id) {
		return productDao.findOne(id, new ProductModel());
	}

	@Override
	public ProductModel update(ProductModel pm) {
		int id = productDao.update(pm);
		return productDao.findOne(id, new ProductModel());
	}

	@Override
	public void delete(List<ProductModel> list) {
		for (ProductModel productModel : list) {
			productDao.delete(productModel);
		}

	}

	@Override
	public List<ProductModel> findAll(Pagination paging) {
		return productDao.findAll(paging);

	}

	@Override
	public List<ProductModel> findProductCateId(Pagination paging) {
		return productDao.findProduct(paging.getCategoryId(), new CategoryModel());
	}

	@Override
	public List<ProductModel> findProductByName(Pagination paging) {
		return productDao.findProduct(paging.getSearch(), new ProductModel());
	}

	@Override
	public List<ProductModel> findProduct(Pagination paging) {
		List<ProductModel> list = null;
		int totalIndex = 0;
		if (paging.getCategoryId() != null && paging.getCategoryId() != 0) {
			paging.setTotalItem(productDao.getTotalItem(paging.getCategoryId(), new CategoryModel()));
		} else if (paging.getSearch() != null) {
			paging.setTotalItem(productDao.getTotalItem(paging.getSearch(), new ProductModel()));
		} else {
			paging.setTotalItem(productDao.getTotalItem());
		}
		if (paging.getTotalItem() > 0) {
			totalIndex = (paging.getTotalItem() % paging.getLimit() == 0) ? (paging.getTotalItem() / paging.getLimit())
					: ((paging.getTotalItem() / paging.getLimit()) + 1);
			paging.setTotalIndex(totalIndex);

		}
		
		if (paging.getCategoryId() != null && paging.getCategoryId() != 0) {
			list = productDao.findProduct(paging, new CategoryModel());
		} else if (paging.getSearch() != null) {
			list = productDao.findProduct(paging, new ProductModel());
		} else {
			list = productDao.findAll(paging);
		}

		return list;
	}

}
