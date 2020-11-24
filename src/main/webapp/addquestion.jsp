<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
 <%@ page isELIgnored="false" %>
 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/exam" user="root" password="#Akshpnwr123#"/>

<sql:query var="rs" dataSource="${db}">select ex_name from ex_exam</sql:query>

<form action="AddQuestion" method="post">
	<select name="ex_name">
		<c:forEach items="${rs.rows}" var="exam">
		
			<option>${exam.ex_name}</option>
		
		</c:forEach>
	</select>
	
	<br>
	<br>
	<input type="text" name="question" placeholder="Enter your question"><br>
	<input type="text" name="option1" placeholder="Enter option 1"><br>
	<input type="text" name="option2" placeholder="Enter option 2"><br>
	<input type="text" name="option3" placeholder="Enter option 3"><br>
	<input type="text" name="option4" placeholder="Enter option 4"><br>
	<input type="text" name="answer" placeholder="Enter answer"><br>
	<br>
	<input type="submit">
</form>
</body>
</html>