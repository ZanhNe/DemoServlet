package com.laptrinhjava.model;

public class UserModel {
	private int userId;
	private String userName;
	private String passWord;
	private int isSeller;
	private int isAdmin;

	public UserModel() {

	}

	public UserModel(int userId, String userName, String passWord, int isSeller, int isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.isSeller = isSeller;
		this.isAdmin = isAdmin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public boolean checkPass(UserModel user) {
		return this.passWord.equals(user.passWord);
	}
	
	public boolean checkAdmin() {
		return (this.isAdmin == 1);
	}
	public boolean checkSeller() {
		return (this.isSeller == 1); 
	}

}
