<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
            method="POST">
        <c:if test="${param.error!=null}">
            <i>Entered invalid username/password</i>
        </c:if>
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
