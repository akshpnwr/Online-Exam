package com.dao;

import java.sql.*;

public class AnswersDao extends BaseDao 
{
	public ResultSet getQuestion(String ex_name)
	{
		String query="select question from questions where ex_name=?";
		connect();
		
		try {
			
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
