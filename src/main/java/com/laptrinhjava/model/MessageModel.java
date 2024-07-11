package com.laptrinhjava.model;


public class MessageModel {
	private String message;
	private String alert;
	
	
	public MessageModel() {
		
	}
	public MessageModel(String message, String alert) {
		this.message = message;
		this.alert = alert;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	
	

}
