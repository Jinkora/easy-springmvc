<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<html>
<head>
    <title>Http Method Sample</title>
    <style>
        span {
            font-size: 16px;
            font-weight:bold
        }
    </style>
</head>
<body>


<h2>Different method Different message</h2>
<p>There is only one url declared like <code>httpMethod/teachers</code> .<br>
    And 4 different methods below:
</p>
<form action="httpMethod/teachers">
    <table>
        <tr>
            <td><span>GET</span></td>
            <td><form:form action="httpMethod/teachers" method="get"><input type="submit" ></form:form></td>
        </tr>
        <tr>
            <td><span>POST</span></td>
            <td><form:form action="httpMethod/teachers" method="post"><input type="submit" ></form:form></td>
        </tr>
        <tr>
            <td><span>PUT</span></td>
            <td><form:form action="httpMethod/teachers" method="put"><input type="submit" ></form:form></td>
        </tr>
        <tr>
            <td><span>DELETE</span></td>
            <td><form:form action="httpMethod/teachers" method="delete"><input type="submit" ></form:form></td>
        </tr>
    </table>
</form>
<p>If you need forms to support all http methods, declare <code>HiddenHttpMethodFilter</code> in <code>web.xml</code> like below:</p>
<pre><code>&lt;filter&gt;
    &lt;filter-name&gt;httpMethodFilter&lt;/filter-name&gt;
    &lt;filter-class&gt;org.springframework.web.filter.HiddenHttpMethodFilter&lt;/filter-class&gt;
&lt;/filter&gt;
&lt;filter-mapping&gt;
    &lt;filter-name&gt;httpMethodFilter&lt;/filter-name&gt;
    &lt;url-pattern&gt;/*&lt;/url-pattern&gt;
&lt;/filter-mapping&gt;
</code></pre>

<p><br>
    Note that most browser does not support many html methods in plain HTML form tag.<br>
    So, just add <code>&lt;%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %&gt;</code> into jsp file then use <code>&lt;form:form&gt;</code> instead of <code>form</code>.</p>
</body>
</html>
