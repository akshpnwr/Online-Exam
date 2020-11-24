package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao 
{
	
	Connection con;
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","#Akshpnwr123#");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
