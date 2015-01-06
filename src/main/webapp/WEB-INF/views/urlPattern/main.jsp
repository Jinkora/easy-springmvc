<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<html>
<head>
    <title>URL Pattern Sample</title>
</head>
<body>

<ul>
    <li>Only 1 param is allowed:<a href="urlPattern/path/user/Kavlez">urlPattern/path/user/{username}</a></li>
    <li>Must be 2 params:<a href="urlPattern/auth/user/Kavlez/pass/0xCAFEBABE">urlPattern/auth/user/{username}/pass/{password}</a></li>
    <li>RegExp is also supported,try 6 digits:<a href="urlPattern/reg/012345">.urlPattern/reg/{6-digits}</a></li>

    <li>Let's try <em>Matrix variable</em>:<a href="urlPattern/matrix/kavlez;age=16">urlPattern/matrix/client/{username};age={age}</a></li>
    <li>Matrix variable could be optional:<a href="urlPattern/matrix_/kavlez;age=16;height=180">urlPattern/matrix/client/{username};age={age}</a></li>
    <li>Matrix variables in a map:<a href="urlPattern/xirtam/kavlez;age=18;height=180">urlPattern/matrix/client/{username};age={age}</a></li>

</ul>
</body>

</html>
