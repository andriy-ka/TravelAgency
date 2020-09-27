<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome </h1>
<h3>List</h3>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>AvailableRooms</th>
        <th>Rooms</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotels}">
        <c:url var="orderLink" value="/hotel/addOrder">
            <c:param name="hotelId" value="${hotel.id}"/>
        </c:url>
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.name}</td>
            <td>${hotel.country}</td>
            <td>${hotel.availableRooms}</td>
            <td>${hotel.rooms}</td>
            <td>
                <a href="${orderLink}">Make order<a/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/hotel/management">Management</a>
</body>
</html>
