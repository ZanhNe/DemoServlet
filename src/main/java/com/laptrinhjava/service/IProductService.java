package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.pagination.Pagination;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findLast(int id);
	List<ProductModel> findTop(int id);
	List<ProductModel> findProductCateId(int categoryId);
	List<ProductModel> findProductByProductId(int productId);
	List<ProductModel> findProductByName(String name);
	
	List<ProductModel> findAll(Pagination paging);
	List<ProductModel> findProductCateId(Pagination paging);
	List<ProductModel> findProductByName(Pagination paging);
	
	List<ProductModel> findProduct(Pagination paging);
	
	List<ProductModel> getProductByCate(String id);
	
	ProductModel findOne(int id);
	ProductModel save(ProductModel pm);
	ProductModel update(ProductModel pm);
	void delete(List<ProductModel> list);
	
}
