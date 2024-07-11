package com.laptrinhjava.pagination;

public class Pagination {
	

	@Override
	public String toString() {
		return "Pagination [limit=" + limit + ", totalItem=" + totalItem + ", totalIndex=" + totalIndex + ", indexPage="
				+ indexPage + ", categoryId=" + categoryId + ", search=" + search + "]";
	}

	private int limit;
	private int totalItem;
	private int totalIndex;
	private int indexPage;
	private Integer offset;
	private Integer categoryId;
	private String search;

	public int getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}

	public Pagination() {

	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public String getSearch() {
			return this.search;
		
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getCategoryId() {
			if (this.categoryId == null)
				return 0;
			return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getOffset() {
		if (this.indexPage != 0 && this.limit != 0)
			this.offset = (this.indexPage - 1)*this.limit;
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	
}
