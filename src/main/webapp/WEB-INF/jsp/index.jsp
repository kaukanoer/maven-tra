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
        <h1>Hello World!</h1>
        <a href="${pageContext.request.contextPath}/request">Request</a>
        <a href="${pageContext.request.contextPath}/settlement">Settlement</a>
        <a href="${pageContext.request.contextPath}/account">Account</a>
        <a href="${pageContext.request.contextPath}/divisi">Divisi</a>        


        <c:forEach var = "divisi" items = "${divisionList}" >
            <c:out value = "${divisi.id}"/>
            <c:out value = "${divisi.divisi}"/>
        </c:forEach>

        <c:forEach var="ac" items ="${accountList}">
            <c:out value ="${ac.nik}"/>
            <c:out value ="${ac.nama}"/>
        </c:forEach>  
        
        <c:forEach var="re" items ="${requestList}">
            <c:out value ="${re.keperluan}"/>
            <c:out value ="${re.hotel}"/>
        </c:forEach> 
        
        <c:forEach var="se" items ="${settlementList}">
            <c:out value ="${se.nota}"/>
            <c:out value ="${se.keterangan}"/>
        </c:forEach> 
        <form action="/addDivision" method="POST">
            Divisi: <input type="text" name="divisionName">
            <input type="submit" value="Simpan"> 
        </form>
        <form action="/deleteDivision/{id}" method="GET">
            Delete id divisi : <input type="text" name="id">
            <input type="submit" value="Delete">            
        </form>
    </body>
</html>
