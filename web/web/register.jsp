<%-- 
    Document   : register
    Created on : May 5, 2018, 5:08:00 PM
    Author     : ehsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register!</h1>
        <form action="register" method="post">
            UserName: <input type="text" name="username"/>
            <br/>
            <br/>
            Password: <input type="password" name="pwd"/>
            <br/>
            <br/>
            Confirm Password: <input type="password" name="cnfrm_pwd"/>
            <br/>
            <br/>
            Email: <input type="email" name="email"/>
            <br/>
            <br/>
            <input type="submit" value="Register"/>
            <a href="index.jsp">Already a user? Click to login.</a>
        </form>
    </body>
</html>
