<%-- 
    Document   : record
    Created on : May 6, 2018, 11:15:10 AM
    Author     : ehsan
--%>

<%@page import="java.util.LinkedHashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
    pageContext.setAttribute("Records", session.getAttribute("Records"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
    </head>
    <body>
        <h1>Records:</h1>
        <c:forEach var='record' items="${Records}">
            ${record.value[0]} (${record.value[2]}) : ${record.value[1]} (Status: ${record.value[3]})
            <br/>
        </c:forEach>
        <form action="fetchCars">
            <input type="submit" value="Rent Another Car"/>
        </form>
        <form action="logout">
            <input type="submit" value="Log Out"/>
        </form>
    </body>
</html>
