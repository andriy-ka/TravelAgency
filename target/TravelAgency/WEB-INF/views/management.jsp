<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list of hotel</title>
</head>
<body>
<h2>List</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>AvailableRooms</th>
        <th>Rooms</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.name}</td>
            <td>${hotel.country}</td>
            <td>${hotel.availableRooms}</td>
            <td>${hotel.rooms}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="addHotel">Add Hotel</a>
</body>
</html>

