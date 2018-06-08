<%-- 
    Document   : index
    Created on : May 5, 2018, 1:14:25 PM
    Author     : ehsan
--%>

<%@page import="com.labppl.entities.Car"%>
<%@page import="com.labppl.hibernate.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Rental</title>
    </head>
    <body>
        <h1>Car Rental System</h1>
        <form method="post" action="verifyLogIn">
            UserName:<input type="text" name="username"/>
            <br/>
            <br/>
            Password:<input type="password" name="pwd"/>
            <br/>
            <br/>
            <input type="submit" value="LogIn"/>
            <a href="register.jsp">New here? Click to register!</a>
        </form>
    </body>
</html>
