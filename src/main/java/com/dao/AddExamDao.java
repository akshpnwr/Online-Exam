package com.dao;
import java.sql.*;
public class AddExamDao extends BaseDao
{
	public boolean store(String ex_name,String ex_date)
	{
		String query="insert into ex_exam values (?,?)";
		
		try 
		{
			connect();
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, ex_name);
			st.setString(2, ex_date);
			
			int i=st.executeUpdate();
			
			if(i==1)
				return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}
}
