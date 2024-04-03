<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body style="background-color: #87CEEB" >
	<form action="insertEmployeeAction" method="post" autocomplete="off">
		<div style="border: 5px solid black; width: 565px; height: 450px; padding-left: 80px; padding-top: 70px">
		<h1 style="margin-left:125px "><U>Employee</U></h1>
			<h1 style="margin-left:70px "><U>Registration Form</U></h1>
			<p style="display: inline-block;">Name: </p><input name="name" type="text" placeholder="Type Here..." />
			<small>${name1}</small>
			<hr>
			<p style="display: inline-block;">Skills: </p>
					   <input name="skills" type="checkbox" value="JAVA" />JAVA &nbsp &nbsp
					   <input name="skills" type="checkbox" value="OOPS" />OOPS &nbsp &nbsp
					   <input name="skills" type="checkbox" value="SPRING MVC" />SPRING MVC &nbsp &nbsp
					   <input name="skills" type="checkbox" value="JDBC" />JDBC &nbsp &nbsp
					   <input name="skills" type="checkbox" value="MySQL" />MySQL &nbsp &nbsp
			<hr>
			<p style="display: inline-block;">Date of birth: </p><input name="dateOfBirth" type="date" onfocus="this.max=new Date().toISOString().split('T')[0]" />
			<small>${dob1}</small>
			<br>
			<br>
			<button>Insert</button>
		</div>
	</form>
	<button><a href="readAllEmployeeAction">ReadAll</a></button>
</body>
</html>


















<%-- <p>Skills:</p>
<c:set var="EmployeeSkills"
	value="JAVA, OOPS, SPRING MVC, JDBC, MYSQL"
	scope="application" />
<c:forEach var="skills1" items="${EmployeeSkills}">
	<input name="skills" value="${skills1}" type="checkbox" />${skills1} &nbsp &nbsp
					   </c:forEach>
<hr> --%>