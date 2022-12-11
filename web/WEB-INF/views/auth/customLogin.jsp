<%--
  Created by IntelliJ IDEA.
  User: freehoon
  Date: 2019-09-10
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>커스텀 로그인 페이지왜안되죵??!!</h1>
    <h2><c:out value="${error}"/></h2>
    <h2><c:out value="${logout}"/></h2>

    <%--<form method="post" action="/auth/customLogin"/>--%>
    <form method="POST" action="/loginCheck"/>

        <div>
            <input type="text" name="username" value="admin">
        </div>
        <div>
            <input type="password" name="password" value="admin">
        </div>
        <div>
            <input type="checkbox" name="remember-me"> Remember Me
        </div>
        <div>
            <input type="submit">
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>


</body>
</html>