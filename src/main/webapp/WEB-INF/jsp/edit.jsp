<%-- 
    Document   : edit
    Created on : Dec 26, 2018, 2:18:23 PM
    Author     : Kaukanoer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="/division/add">
            <h4>Divisi</h4>
            <input type="hidden" name="id" value="${field.id}"/>
            <input type="text" name="divisionName" value="${field.divisi}"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
