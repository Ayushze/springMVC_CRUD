<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body style="background-color: #87CEEB">
    <form action="updateEmployee/${employee.id}" method="post" autocomplete="off">
        <div style="border: 5px solid black; width: 580px; height: 450px; padding-left: 80px; padding-top: 80px">
            <h1 style="margin-left:90px "><U>Update Page</U></h1>
            <%-- <p>Employee ID: ${employee.id}</p> --%>
            <p>Name: <input name="name" value="${employee.name}" type="text" /></p>
            <p style="display: inline-block;">Skills:</p>
            <c:set var="EmployeeSkills1" value="JAVA,OOPS,SPRING MVC,JDBC,MySQL" scope="application" />
			<c:forEach var="skill" items="${EmployeeSkills1.split(',')}">
	    		<c:set var="isChecked" value="false" />
	    		<c:forEach var="empSkill" items="${employee.skills}">
	        		<c:if test="${empSkill eq skill}">
	            		<c:set var="isChecked" value="true" />
	        		</c:if>
	    		</c:forEach>
	    		<input name="skills" value="${skill}" ${isChecked ? 'checked' : ''} type="checkbox" />${skill} &nbsp &nbsp
			</c:forEach>
            <hr> 
            <p>Date of birth: <input name="dateOfBirth" value="${employee.dateOfBirth}" type="date" onfocus="this.max=new Date().toISOString().split('T')[0]" /></p>
            <button type="submit">Update</button>
        </div>
    </form>
    <hr>
</body>
</html>
