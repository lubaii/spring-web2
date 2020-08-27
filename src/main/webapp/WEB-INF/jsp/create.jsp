<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/course/save" method="post">
    <input name="name"/>
    <input name="duration" type="number"/>
    <button type="submit">Cоздать</button>
</form>

<form method="post" action="/courseUpload" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file">
    <input type="submit">
</form>
</body>
</html>
