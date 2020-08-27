<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Courses</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>${courses}</h1>
<%--<a href="/setCookie">Set cookie</a>--%>

<sec:authorize access="isAuthenticated()">
    <a href="/setCookie">set cookie</a>
    </sec:authorize>
<script type="text/javascript">
    $(document).ready(function() {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
                 type:"POST",
                 url:"/courses/add",
                 /*contextType: "application/json",*/ /* код преподавателя*/
                 data: JSON.stringify({name: "web course",duration: 120}),
                 dataType: 'json'
            })
    })
</script>
</body>
</html>
