package com.dao;
import java.sql.*;

public class ResultDao extends BaseDao
{
	public ResultSet getAnswers(String ex_name) 
	{
		String query="select answer from questions where ex_name=?";
		
		
		try {
			connect();
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, ex_name);
			
			ResultSet rs=st.executeQuery();
			
			return rs;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
