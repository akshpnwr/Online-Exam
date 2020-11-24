package com.panwar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AnswersDao;


public class Answers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession ses=request.getSession();
		String ex_name=ses.getAttribute("ex_name").toString();
		
		PrintWriter out=response.getWriter();
		out.println(ex_name);
		
		AnswersDao d=new AnswersDao();
		ResultSet rs=d.getQuestion(ex_name);
		
		List<String> questions=new ArrayList<String>();
		
		try {
			while(rs.next())
			{
				questions.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		List<String> answers=new ArrayList<String>();
		
		Iterator it=questions.iterator();
		
		//storing answers by user
		
		while(it.hasNext())
		{
			answers.add(request.getParameter(it.next().toString()));
			
		}
		
		
		ses.setAttribute("answers", answers);
		response.sendRedirect("Result");
	}
}
