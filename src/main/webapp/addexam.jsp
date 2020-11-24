<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="index.css" >

<meta charset="ISO-8859-1">

</head>
<body>

<%
	response.setHeader("Cache-control","no-cache,no-store,must-revalidate");

	if(session.getAttribute("uname")==(null))
	{
		response.sendRedirect("index.jsp");	
	}
%>

<form action="AddExam" method="post">

	Enter exam name : <input type="text" name="ex_name"> <br><br>
	Enter exam date :   <input type="date" name="ex_date"><br> <br>
	
	<input type="submit" value="submit">
</form>
</body>
</html>