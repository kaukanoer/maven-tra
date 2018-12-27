<%-- 
    Document   : index
    Created on : Dec 25, 2018, 1:46:25 PM
    Author     : Kaukanoer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/request/">Request</a>
        <form action="/division/add" method="POST">
            <input type="hidden" name="id">
            Divisi: <input type="text" name="divisionName">
            <input type="submit" value="Simpan"> 
        </form>
        <table style="border: 1px">
            <thead>
                <th>Id</th>
                <th>Nama</th>
                <th>Action</th>
            </thead>
            <tbody>
                <c:forEach var = "divisi" items = "${divisionList}">
                    <tr>
                        <td><c:out value = "${divisi.id}"/></td>
                        <td><c:out value = "${divisi.divisi}"/></td>
                        <td><a href="edit/${divisi.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>        
    </body>
</html>
