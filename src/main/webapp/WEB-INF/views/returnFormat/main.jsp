<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp"%>
<%@ include file="/taglib.jsp"%>
<html>
<head>
    <title>Return Format Sample</title>
</head>
<body>


<p><br>
    Now, let's  post image file to <code>com.kavlez.controller.MultipartController.headImag</code></p>

<form action="multiPart/image" enctype="multipart/form-data" method="post">
    <input type="file" name="image" />
    <input type="submit" />
</form>

</body>
</html>
