<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make Order</title>
</head>
<body>

<p><b>Add New Hotel</b></p>
<form:form modelAttribute="order" action="addOrder">
    <table>
        <form:hidden path="order_id"/>
        <tr>
            <td>Order name:</td>
            <td><form:input path="username" type="text"/></td>
        </tr>
        <tr>
            <td>Data: </td>
            <td><form:input path="data" type="data"/></td>
        </tr>
        <tr>
            <td>How many rooms?</td>
            <td><form:input path="bookedrooms" type="number"/></td>
        </tr>
            <td></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
