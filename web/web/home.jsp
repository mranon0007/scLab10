<%-- 
    Document   : home
    Created on : May 5, 2018, 9:47:30 PM
    Author     : ehsan
--%>

<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.labppl.entities.Car"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Map<String, Integer[]> Cars = new LinkedHashMap<String, Integer[]>();
    for(Car car : (List<Car>)session.getAttribute("Cars")){
        Cars.put(car.getName(), new Integer[]{car.getId(), car.getPrice()});
    }
    pageContext.setAttribute("Cars", Cars);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Pick a Car:</h1>
        <form action="record" method="post">
            <c:forEach var='car' items="${Cars}">
                <input type="radio" name="carrb" value="${car.value[0]}" /> 
                ${car.key} (Price:${car.value[1]})
                <br/>
            </c:forEach>
            <br/>
            <input type="checkbox" name="driver"/>With Driver?
            <br/>
            <br/>
            <input type="submit" value="Rent Car"/>
        </form>
        <form action="logout">
            <input type="submit" value="Log Out"/>
        </form>
    </body>
</html>
