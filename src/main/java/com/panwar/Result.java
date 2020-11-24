package com.panwar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResultDao;


public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int marks = 0;
		
		HttpSession ses=request.getSession();
		
		String ex_name=ses.getAttribute("ex_name").toString();
		List<String> answers=(List<String>) ses.getAttribute("answers");
		
		List<String> cor_answers=new ArrayList<String>();
		
		ResultDao d=new ResultDao();
		ResultSet rs=d.getAnswers(ex_name);
		
		try {
			while(rs.next())
			{
				cor_answers.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		for(int i=0;i<answers.size();i++)
			{
				try {
						if(answers.get(i).equals((cor_answers).get(i)))
						{
							marks=marks+10;
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				
			}
		
			
		
		
		request.setAttribute("marks", marks);
		
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
