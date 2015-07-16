<%-- 
    Document   : response
    Created on : 16/07/2015, 03:56:59 PM
    Author     : Valery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.game.Player" />
        <jsp:setProperty name="mybean" property="name" />
        <jsp:setProperty name="mybean" property="option" />
        
    </body>
</html>
