package com.laptrinhjava.utils;

import javax.servlet.http.HttpServletRequest;

import com.laptrinhjava.model.MessageModel;

public class MessageUtil {
	private static final MessageUtil messageUtil = new MessageUtil();
	private static MessageModel messageModel;
	
	
	
	
	public static MessageUtil of(String message, String alert) {
		messageModel = new MessageModel(message, alert);
		return messageUtil;
	}
	
	public void buildMessage(HttpServletRequest request) {
		request.setAttribute("messageModel", messageModel);
	}
	
	

}
