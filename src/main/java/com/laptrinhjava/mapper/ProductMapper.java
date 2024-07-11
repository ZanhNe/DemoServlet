package com.laptrinhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjava.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet rs) {

		ProductModel pd = new ProductModel();
		try {
			pd.setProductId(rs.getInt("ProductID"));
			pd.setImageLink(rs.getString("ImageLink"));
			pd.setProductName(rs.getString("ProductName"));
			pd.setDescription(rs.getString("Description"));
			pd.setPrice(rs.getInt("Price"));
			pd.setCategoryId(rs.getInt("CategoryID"));
			pd.setSellerId(rs.getInt("SellerID"));
			pd.setAmount(rs.getInt("Amount"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

}
