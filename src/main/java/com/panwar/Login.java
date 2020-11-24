package com.panwar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminLoginDao;


public class Login extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		AdminLoginDao d=new AdminLoginDao();
		
		if(d.check(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname",uname );
			
			response.sendRedirect("adminhome.jsp");
			
		}
			
		else
		{
			response.sendRedirect("adminlogin.jsp");	
		}
		
	}

}
