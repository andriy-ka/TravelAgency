<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
<table border="1">
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
<a href="/hotel/homepage"><-Back</a>
</body>
</html>
