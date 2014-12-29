<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp"%>
<%@ include file="/taglib.jsp"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>Yep! This is hello.jsp</h2>
post image file to
<code>com.kavlez.controller.MultipartController.headImag</code>
<form:form action="./headImage" enctype="multipart/form-data" method="post">
    <input type="file" name="image" />
    <input type="submit" />
</form:form>
</body>
</html>
