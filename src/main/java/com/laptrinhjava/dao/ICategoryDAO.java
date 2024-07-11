package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
