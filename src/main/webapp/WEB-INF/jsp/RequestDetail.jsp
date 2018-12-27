<%-- 
    Document   : RequestEdit
    Created on : Dec 26, 2018, 8:54:02 PM
    Author     : Kaukanoer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1> 
                <a href="${pageContext.request.contextPath}/request/">Back</a>

        <form method="GET" action="/request/{id}">
            <input type="text" name="nik" value = "${field.accountNik.getNik()}"/>
            <input type="text" name="keperluan" value = "${field.keperluan}"/>
            <input type="text" name="catatan" value = "${field.catatan}"/>
            <input type="text" name="status" value = "${field.status}"/>
        </form>
<!--
        <form method="POST" action="/request/add">
            Note Approved: <input type="text" name="catatan">
            <input type="hidden" name="type" value="1">
            <input type="hidden" name="id" value="${field.id}">
            <input type="submit" value="Approve">
        </form>
            
        <form method="POST" action="/request/add">
            Note Rejected: <input type="text" name="catatan">
            <input type="hidden" name="type" value="0">
            <input type="hidden" name="id" value="${field.id}">
            <input type="submit" value="Reject">
        </form>-->
    </body>
</html>
