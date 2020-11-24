<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>
 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
	HttpSession ses=request.getSession();
	if(session.getAttribute("uname")==(null))
	{
		response.sendRedirect("index.jsp");	
	}
	
	if(ses.getAttribute("ex_name")==null)
	{
		response.sendRedirect("userhome.jsp");	
	}
	String ex_name=request.getAttribute("ex_name").toString();
%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/exam" user="root" password="#Akshpnwr123#"/>

<sql:query var="rs" dataSource="${db}">select question,option1,option2,option3,option4 from questions where ex_name='${ex_name}'</sql:query>

<form action="Answers" method="post">
	
	
	<c:forEach items="${rs.rows}" var="qo">
		
		Q. ${qo.question}<br>
		
		
		<input type="radio" id="option1" name="${qo.question}" value="${qo.option1}">
		<label for="option1">${qo.option1}</label><br>
		
		<input type="radio" id="option2" name="${qo.question}" value="${qo.option2}">
		<label for="option2">${qo.option2}</label><br>
		
		<input type="radio" id="option3" name="${qo.question}" value="${qo.option3}">
		<label for="option3">${qo.option3}</label><br>
		
		<input type="radio" id="option4" name="${qo.question}" value="${qo.option4}">
		<label for="option4">${qo.option4}</label><br>
		
		
		
	</c:forEach>
	
	<%
		ses=request.getSession();
		ses.setAttribute("ex_name", ex_name);
	%>
	
	<input type="submit">
	
	
	</form>

</body>
</html>