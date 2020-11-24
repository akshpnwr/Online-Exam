package com.panwar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserLoginDao;


public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		UserLoginDao d=new UserLoginDao();
		
		if(d.check(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname",uname );
			
			response.sendRedirect("userhome.jsp");
			
		}
			
		else
		{
			response.sendRedirect("userlogin.jsp");	
		}
	}

}
