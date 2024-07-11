package com.laptrinhjava.model;


public class CategoryModel {
	private int categoryId;
	private String categoryName;
	private String icon;
	
	public CategoryModel() {
		
	}
	
	public CategoryModel(int categoryId, String categoryName, String icon) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.icon = icon;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
