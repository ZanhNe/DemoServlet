package com.laptrinhjava.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionProvider {
	static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	private static final String url = resourceBundle.getString("url");
	private static final String userName = resourceBundle.getString("user");
	private static final String pass = resourceBundle.getString("password");
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(resourceBundle.getString("driverName"));
			conn = DriverManager.getConnection(url, userName, pass);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

}
