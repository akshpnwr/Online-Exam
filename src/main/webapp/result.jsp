<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="index.css" >
<meta charset="ISO-8859-1">

</head>
<body>

	<%
	
	
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		
		if(session.getAttribute("uname")==(null))
		{
			response.sendRedirect("index.jsp");	
		}	
	
		HttpSession ses=request.getSession();
		
		String ex_name=ses.getAttribute("ex_name").toString();
		int marks=Integer.parseInt(request.getAttribute("marks").toString());
	
	%>
	
<form action="userhome.jsp">
<h2>Results</h2>

Your marks for the ${ex_name} exam are : ${marks} <br><br>

<%
		ses.removeAttribute("ex_name");	
		
%>

<input type="submit" value="home page">

</form>		

</body>
</html>