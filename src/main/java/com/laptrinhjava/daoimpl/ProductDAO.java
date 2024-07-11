package com.laptrinhjava.daoimpl;

import java.util.List;

import com.laptrinhjava.dao.IProductDAO;
import com.laptrinhjava.mapper.ProductMapper;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.model.ProductModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.pagination.Pagination;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> list = null;
		String sql = "select * from product";
		list = query(sql, new ProductMapper());
		return list;
	}

	@Override
	public List<ProductModel> findLast(int numberOfLimit) {
		List<ProductModel> list = null;
		String sql = "select * from product order by productid desc limit ?";
		list = query(sql, new ProductMapper(), numberOfLimit);
		return list;
	}

	@Override
	public List<ProductModel> findTop(int numberOfLimit) {
		List<ProductModel> list = null;
		String sql = "select * from product order by amount limit ?";
		list = query(sql, new ProductMapper(), numberOfLimit);
		return list;
	}

	@Override
	public List<ProductModel> findProduct(int categoryId, CategoryModel categoryModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where categoryid = ?";
		list = query(sql, new ProductMapper(), categoryId);
		return list;
	}

	@Override
	public List<ProductModel> findProduct(int productId, ProductModel productModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where productid = ?";
		list = query(sql, new ProductMapper(), productId);
		return list;
	}

	@Override
	public List<ProductModel> findProduct(String productName, ProductModel productModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where productname like ?";
		list = query(sql, new ProductMapper(), "%" + productName + "%");
		return list;
	}

	@Override
	public ProductModel findOne(int productId, ProductModel productModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where productid = ?";
		list = query(sql, new ProductMapper(), productId);
		return list.get(0);
	}

	@Override
	public int save(ProductModel productModel) {
		String sql = "insert into product(productname, description, price, imagelink, categoryid, sellerid, amount) values(?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, productModel.getProductName(), productModel.getDescription(), productModel.getPrice(),
				productModel.getImageLink(), productModel.getCategoryId(), productModel.getSellerId(),
				productModel.getAmount());
	}

	@Override
	public int update(ProductModel productModel) {
		String sql = "update product set productname = ?, description = ?, price = ?, imagelink = ?, categoryid = ?, sellerid = ?, amount = ? where productid = ?";
		update(sql, productModel.getProductName(), productModel.getDescription(), productModel.getPrice(),
				productModel.getImageLink(), productModel.getCategoryId(), productModel.getSellerId(),
				productModel.getAmount(), productModel.getProductId());
		return productModel.getProductId();
	}

	@Override
	public void delete(ProductModel productModel) {
		String sql = "delete from product where productid = ?";
		update(sql, productModel.getProductId());

	}

	@Override
	public List<ProductModel> findProduct(int sellerId, UserModel userModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where sellerid = ?";
		list = query(sql, new ProductMapper(), sellerId);
		return list;
	}

	@Override
	public List<ProductModel> findProduct(int fromPrice, int toPrice, ProductModel productModel) {
		List<ProductModel> list = null;
		String sql = "select * from product where price between ? and ?";
		list = query(sql, new ProductMapper(), fromPrice, toPrice);
		return list;
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from product";
		return count(sql);
	}

	@Override
	public int getTotalItem(String productName, ProductModel productModel) {
		String sql = "select count(*) from product where productName like ?";
		return count(sql, "%" + productName + "%");
	}

	@Override
	public int getTotalItem(int categoryId, CategoryModel categoryModel) {
		String sql = "select count(*) from product where categoryid = ?";
		return count(sql, categoryId);
	}

	@Override
	public List<ProductModel> findAll(Pagination paging) {
		String sql = "select * from product limit ? offset ?";
		return query(sql, new ProductMapper(), paging.getLimit(), paging.getOffset());
	}

	@Override
	public List<ProductModel> findProduct(Pagination paging, CategoryModel categoryModel) {
		String sql = "select * from product where categoryId = ? limit ? offset ?";
		return query(sql, new ProductMapper(), paging.getCategoryId(), paging.getLimit(), paging.getOffset());
	}

	@Override
	public List<ProductModel> findProduct(Pagination paging, ProductModel productModel) {
		String sql = "select * from product where productname like ? limit ? offset ?";
		return query(sql, new ProductMapper(), "%" + paging.getSearch() + "%", paging.getLimit(), paging.getOffset());
	}
	

}
