<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp"%>
<%@ include file="/taglib.jsp"%>
<html>
<head>
    <title>Message Convert</title>
</head>
<body>
<h2>Message Convert</h2>

<p>Let's see how <strong>@RequestBody</strong> works.</p>
<form method="post" action="messageConvert/body">
    <input name="firstName" value="Kavlez"/>
    <input name="lastName" value="Jin"/>
    <input type="submit"/>
</form>
</body>
</html>
