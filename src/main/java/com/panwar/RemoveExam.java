package com.panwar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RemoveDao;

public class RemoveExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ex_name=request.getParameter("ex_name");
		
		RemoveDao d=new RemoveDao();
		d.remove(ex_name);
		
		response.sendRedirect("adminhome.jsp");
	}

}
