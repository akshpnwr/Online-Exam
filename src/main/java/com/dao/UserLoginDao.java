package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao extends BaseDao 
{
	public boolean check(String uname,String pass)
	{
		String query="select * from user where username=? and password=?";
		
		try
		{
			connect();
			
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs=st.executeQuery();
			
			
			if(rs.next())
				return true;
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return false;
	}
}
