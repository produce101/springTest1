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
Hello Page! 메인페이지입니다~

<form action="insertFile" method="post" enctype="multipart/form-data">


    <p>업로드</p>
    <input type="file" name="uploadFile"/>

    <input type="submit" value="확인"/>

</form>


<form action="data1" method="post" enctype="multipart/form-data">


    <p>확인스</p>
    <input type="file" name="uploadFile"/>

    <input type="submit" value="확인"/>

</form>

</body>
</html>