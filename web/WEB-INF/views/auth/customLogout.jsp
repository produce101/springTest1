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

    <h1>로그아웃 페이지</h1>

    <form action="/auth/customLogout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button>로그아웃</button>
    </form>

</body>
</html>