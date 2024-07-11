package com.laptrinhjava.serviceimpl;

import java.util.List;

import com.laptrinhjava.dao.ICategoryDAO;
import com.laptrinhjava.daoimpl.CategoryDAO;
import com.laptrinhjava.model.CategoryModel;
import com.laptrinhjava.service.ICategoryService;

public class CategoryService implements ICategoryService{
	ICategoryDAO categoryDao;
	public CategoryService() {
		categoryDao = new CategoryDAO();
	}
	@Override
	public List<CategoryModel> findAll(){
		return categoryDao.findAll();
	}
	

}
