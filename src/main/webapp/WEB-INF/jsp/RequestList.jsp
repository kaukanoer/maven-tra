<%-- 
    Document   : RequestList
    Created on : Dec 26, 2018, 8:53:51 PM
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
        <h1>Hello World!</h1>
<!--request = new Requests(id, keperluan, transportBerangkat, tanggalBerangkat, transportPulang, tanggalPulang, hotel, cekkin, cekkout, catatan, "Approved", "0", account);-->

        <form action="/request/add" method="POST">
            <input type="hidden" name="id">
            Keperluan: <input type="text" name="keperluan"><br>
            NIK: <input type="text" name="nik"><br>
            Transport Berangkat: <input type="text" name="transportBerangkat"><br>
            Waktu Berangkat: <input type="text" name="waktuBerangkat"><br>
            Transport Pulang: <input type="text" name="transportPulang"><br>
            Waktu Pulang: <input type="text" name="waktuPulang"><br>
            Hotel: <input type="text" name="hotel"><br>
            Cek In: <input type="text" name="cekin"><br>
            Cek Out: <input type="text" name="cekout"><br>
            <input type="submit" value="Save"><br>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nik</th>
                    <th>Keperluan</th>
                    <th>Catatan</th>
                    <th>Status</th>
                    <th colspan="6">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "request" items = "${requestList}">
                    <tr>
                        <td>No</td>
                        <td><c:out value = "${request.accountNik.getNik() }"/></td>
                        <td><c:out value = "${request.keperluan}"/></td>
                        <td><c:out value = "${request.catatan}"/></td>
                        <td><c:out value = "${request.status}"/></td>
                        <td><a href="./${request.id}">Detail</a></td>
                        <td>
                            <form method="POST" action="/request/approval">
                                <input type="hidden" name="id" value="${request.id}">
                                <input type="hidden" name="type" value="1">
                                Note Approved: <input type="text" name="catatan">
                                <input type="submit" value="Approve">
                            </form>
                        </td>
                        <td>
                            <form method="POST" action="/request/approval">
                                <input type="hidden" name="id" value="${request.id}">
                                <input type="hidden" name="type" value="0">
                                Note Rejected: <input type="text" name="catatan">
                                <input type="submit" value="Reject">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>