package com.panwar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddExamDao;

public class AddExam extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ex_name=request.getParameter("ex_name");
		String ex_date=request.getParameter("ex_date");
		
		AddExamDao d=new AddExamDao();
	    
		if(d.store(ex_name, ex_date))
		{
			response.sendRedirect("adminhome.jsp");
		}
		
		else
		{
			response.sendRedirect("addexam.jsp");
		}
	}

}
