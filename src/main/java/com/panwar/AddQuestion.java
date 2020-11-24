package com.panwar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddQuestionDao;


public class AddQuestion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ex_name=request.getParameter("ex_name");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		String[] option=new String[4]; 
		
		for(int i=1;i<=4;i++)
		{
			option[i-1]=request.getParameter("option"+i);
		}
		
		AddQuestionDao d=new AddQuestionDao();
		if(d.store(ex_name, question,answer,option))
		{
			response.sendRedirect("adminhome.jsp");
		}
		else
		{
			response.sendRedirect("addquestion.jsp");
		}
	}
}
