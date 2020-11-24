<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

<label>USER MODULE </label>
<br>
<br>

	<%
		response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
		
		if(session.getAttribute("uname")==(null))
		{
			response.sendRedirect("index.jsp");	
		}
	%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/exam" user="root" password="#Akshpnwr123#"/>

<sql:query var="rs" dataSource="${db}">select ex_name from ex_exam</sql:query>

<form action="">

	Select Exam : 
	<select name="ex_name">
		<c:forEach items="${rs.rows}" var="exam">
		
			<option>${exam.ex_name}</option>
		
		</c:forEach>
	</select>
	<br><br><input type="submit" value="Take Exam" formaction="Exam"><br><br>
	<input type="submit" value="logout" formaction="Logout">
	
</form>

</body>
</html>