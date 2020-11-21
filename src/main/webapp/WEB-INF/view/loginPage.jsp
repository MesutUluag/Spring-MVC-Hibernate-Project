<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
            method="POST">
        <p>
            Username <input type="text" name="username">
        </p>
        <p>
            Password <input type="text" name="password">
        </p>
        <input type="submit" value="Login">
    </form:form>
</body>
</html>
