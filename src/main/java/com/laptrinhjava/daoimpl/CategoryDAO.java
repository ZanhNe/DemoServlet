package com.laptrinhjava.daoimpl;

import java.util.List;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.mapper.CategoryMapper;
import com.laptrinhjava.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> list = null;
		String sql = "select * from category";
		list = query(sql, new CategoryMapper());
		return list;
	}

}
