package com.panwar;

import java.io.IOException;
import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ExamDao;


public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String ex_name=request.getParameter("ex_name");
		
		request.setAttribute("ex_name", ex_name);
		
		RequestDispatcher rd=request.getRequestDispatcher("exam1.jsp");
		rd.forward(request, response);
		
	}

}
