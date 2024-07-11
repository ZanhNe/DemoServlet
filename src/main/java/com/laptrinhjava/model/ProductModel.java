package com.laptrinhjava.model;

public class ProductModel {

	private int productId;
	private String productName;
	private String description;
	private int price;
	private String imageLink;
	private int categoryId;
	private int sellerId;
	private int amount;

	public ProductModel() {

	}

	public ProductModel(int productId, String productName, String description, int price, String imageLink,
			int categoryId, int sellerId, int amount) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageLink = imageLink;
		this.categoryId = categoryId;
		this.sellerId = sellerId;
		this.amount = amount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", imageLink=" + imageLink + ", categoryId=" + categoryId + ", sellerId="
				+ sellerId + ", amount=" + amount + "]";
	}
}
