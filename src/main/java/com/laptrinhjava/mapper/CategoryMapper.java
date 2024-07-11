package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel cm = new CategoryModel();
		try {
			cm.setCategoryId(rs.getInt("CategoryID"));
			cm.setCategoryName(rs.getString("CategoryName"));
			cm.setIcon(rs.getString("Icon"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cm;
	}
	

}
