package com.dao;
import java.sql.*;

public class AddQuestionDao extends BaseDao
{
	public boolean store(String ex_name,String question,String answer,String[] option)
	{
		
		String query="insert into questions values(?,?,?,?,?,?,?)";
		connect();
		
		try {
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,ex_name);
			st.setString(2, question);
			st.setString(3, answer);

			int i=4;
			for(String items:option)
			{
				st.setString(i, items);
				i++;
			}
			
			st.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
}
