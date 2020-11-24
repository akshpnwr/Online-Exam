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
	response.setHeader("Cache-control","no-cache,no-store,must-revalidate");

	if(session.getAttribute("uname")==(null))
	{
		response.sendRedirect("index.jsp");	
	}
%>

<label>ADMIN MODULE </label>
<br>
<br>

<form>

	<input type="submit" value="Add Exam" formaction="addexam.jsp"> <br>
	<input type="submit" value="Add Question" formaction="addquestion.jsp"> <br>
	<input type="submit" value="Remove Exam" formaction="removeexam.jsp"> <br>
	
</form>

<br>
<form action="Logout">
	<input type="submit" value=" Log out">
</form>


</body>
</html>