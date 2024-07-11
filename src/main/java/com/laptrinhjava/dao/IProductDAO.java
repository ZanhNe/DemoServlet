package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.pagination.Pagination;

public interface IProductDAO {
	List<ProductModel> findAll();
	List<ProductModel> findAll(Pagination paging);
	List<ProductModel> findLast(int numberOfLimit);
	List<ProductModel> findTop(int numberOfLimit);
	List<ProductModel> findProduct(int categoryId, CategoryModel categoryModel);
	List<ProductModel> findProduct(Pagination paging, CategoryModel categoryModel);
	List<ProductModel> findProduct(int productId, ProductModel productModel);
	List<ProductModel> findProduct(String productName, ProductModel productModel);
	List<ProductModel> findProduct(Pagination paging, ProductModel productModel);
	List<ProductModel> findProduct(int sellerId, UserModel um);
	List<ProductModel> findProduct(int fromPrice, int toPrice, ProductModel productModel);

	
	int getTotalItem();
	int getTotalItem(String productName, ProductModel productModel);
	int getTotalItem(int categoryId, CategoryModel categoryModel);
	
	int save(ProductModel productModel);
	int update(ProductModel productModel);
	void delete(ProductModel productModel);
	ProductModel findOne(int productId, ProductModel productModel);
}
