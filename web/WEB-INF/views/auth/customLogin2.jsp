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
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

    <h1>커스텀 로그인 페이지왜안되죵??</h1>
    <h2>${error}</h2>
    <h2>${logout}</h2>

    <%--<form method="post" action="/auth/customLogin"/>--%>
    <form method="post" action="/loginCheck2"/>

        <div>
            <input type="text" name="username" id="username" value="admin">
        </div>
        <div>
            <input type="password" name="password" id="password" value="admin">
        </div>
        <div>
            <input type="checkbox" name="remember-me" id="rememberme"> Remember Me
        </div>
        <div>
            <input type="button" id="regist" value="버튼~~3">
           <%-- <input type="submit">--%>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>

</body>
</html>


<script>

    $(function () {

        $("#regist").click(function() {

            var username = $("#username").val();
            var password = $("#password").val();
            var rememberme = $("#rememberme").val();

            var csrfToken = "${_csrf.token}";
            var csrfHeader = "${_csrf.headerName}";

            //alert("유저네임은 " + username + " " + " " + csrfToken + " " + csrfHeader + " " + password);

            var params = "userId=" + username + "&password=" + password + "&rememberme=" + rememberme;


            var jsonData = {
                "username" : username,
                "password" : password,
                "remember-me": rememberme
            }

            $.ajax({
                type: "POST",
                url: '/loginCheck2',
                //contentType: 'application/json; charset=utf-8',
                contentType: 'application/x-www-form-urlencoded; charset=utf-8',
                dataType:"text",
                //data: JSON.stringify(jsonData),
                data: jsonData,

                beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                },

                success(e) {

                    if (e === 'notAuth') {
                      alert("아이디가 맞지 않거나\n비밀번호가 틀립니다.");
                    } else if ( e === 'success') {
                        location.href = '/auth/test1';
                    } else if ( e === 'admin') {
                        //location.href = '/auth/test1';
                        alert("당신은 어드민으로 로그인하셨습니다 " + e);
                        location.href = '/auth/admin';
                    }

                    //alert("성공" + e);
                },
                error(e) {
                    alert("실패: " + JSON.stringify(e));
                    console.log("실패 이유는"  + e);
                }

            });
        });

    });



</script>