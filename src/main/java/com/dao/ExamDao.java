package com.dao;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class ExamDao extends BaseDao 
{
	public String question;
	public String option1,option2,option3,option4;
	
	

	@Override
	public String toString() {
		return "ExamDao [question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + "]";
	}

	public ResultSet getQuestions(String ex_name)
	{
		String query="select question,option1,option2,option3,option4 from questions where ex_name=?";
		connect();
		
		try
		{
			PreparedStatement st=con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			st.setString(1, ex_name);
			
			ResultSet rs=st.executeQuery();
		
			return rs;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
		
	}
	
	//display list
	public StringBuilder display(List<ExamDao> qo)
	{
		StringBuilder sb=new StringBuilder();
		
		Iterator<ExamDao> it=qo.iterator();
		
		while(it.hasNext())
		{
			sb.append(it.next());
		}
		
		return sb;
	}
}
