<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <div>테스트입니다~~</div>
    <div> <sec:authentication property="principal"/> </div>

    <div> <sec:authentication property="principal.Username"/> </div>

    <div> <sec:authentication property="principal.memberVO"/> </div>

    <div> <sec:authentication property="principal.memberVO.userId"/> </div>

    <div> <sec:authentication property="principal.memberVO.info"/> </div>

    <div>

        <%--<sec:authorize access='hasRole("admin")'>
            <button class="btn btn-small btnGuardar" href="#dlgGuardar" data-toggle="modal">
                <i class="icon-hdd"></i> <strong>Una Opcion</strong>
            </button>
        </sec:authorize>--%>

        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'DEVELOPER')">
            가나다라 123123아아아아
        </sec:authorize>


            <sec:authorize access="hasRole('ROLE_ADMIN')">
                ㅁㄴㅇㄴㅁㅇㄴㅇ
            </sec:authorize>


            <sec:authorize access="permitAll()">
                <div>
                    wdwd
                </div>
            </sec:authorize>


            <sec:authorize access="denyAll()">
                <div>
                    zxczxcxzc
                </div>
            </sec:authorize>


            <sec:authorize access="isAnonymous()">
                <div>
                    zxczxcasdasdqweqwe1212
                </div>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <div>
                    asdsadqwqeqwe1111
                </div>
            </sec:authorize>


            <sec:authorize access="isFullyAuthenticated()">
                <div>
                    111122221111qqq111
                </div>
            </sec:authorize>

            <%--<div> <sec:authorize access="denyAll"/> zxczxcxzc</div>--%>
    </div>


</body>
</html>