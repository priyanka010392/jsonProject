package com.sean.test;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	 

public class DBUtil {
	
	
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_url = "jdbc:mysql://localhost/test";
	
	static final String USER = "root";
	static final String Password= "root";
	

	public  static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_Driver);
			
			
			conn= DriverManager.getConnection(DB_url, USER, Password);
			conn.setAutoCommit(false);
		
			System.out.println("database connected!");
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
}
	
	
	public static void closeConnection(Connection conn){
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
