<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
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
    <c:forEach var="hotel" items="${foundHotels}">
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
<a href="/hotel/management">Management</a>
</body>
</html>
