<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>list of hotel</title>
</head>
<body>
<h2>List</h2>
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
        <c:url var="updateLink" value="/hotel/showUpdateForm">
            <c:param name="hotelId" value="${hotel.id}"/>
        </c:url>
        <c:url var="deleteLink" value="/hotel/deleteRecord">
            <c:param name="hotelId" value="${hotel.id}"/>
        </c:url>
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.name}</td>
            <td>${hotel.country}</td>
            <td>${hotel.availableRooms}</td>
            <td>${hotel.rooms}</td>
            <td>
                <a href="${updateLink}">Update<a/> | <a href="${deleteLink}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="addHotel">Add Hotel</a>

<h2>List of Orders</h2>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Hotel</th>
        <th>Email</th>
        <th>Date</th>
        <th>Room</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.ordername}</td>
            <td>${order.hotel}</td>
            <td>${order.email}</td>
            <td>${order.date}</td>
            <td>${order.room}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

