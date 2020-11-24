package com.dao;

import java.sql.PreparedStatement;

public class RemoveDao extends BaseDao
{
	public void remove(String ex_name)
	{
		String query="delete from ex_exam where ex_name=?";
		
		try 
		{
			connect();
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, ex_name);
		
			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
	}
}
