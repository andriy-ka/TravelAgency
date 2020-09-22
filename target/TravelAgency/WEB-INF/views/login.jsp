<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <title>Security</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>Login</h1>
<form c:action="@{/login}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>