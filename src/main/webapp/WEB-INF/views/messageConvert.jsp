<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<%@ include file="/js.jsp" %>
<html>
<head>
    <title>Message Convert</title>
</head>
<body>
<h2>Message Convert</h2>

<p>Let's see how <strong>@RequestBody</strong> works.</p>

<div>
    <form method="post" action="messageConvert/body">
        <label>
            <input name="firstName" value="Kavlez"/>
        </label>
        <label>
            <input name="lastName" value="Jin"/>
        </label>
        <input type="submit"/>
    </form>
</div>
<br/>

<p>
    Let controller method return as xml:
    <a onclick="reqSubjectAsXML()" href="###">request</a>
</p>

<div id="subject"></div>
</body>
<script>
    function reqSubjectAsXML() {
        $.ajax({
            type: "GET",
            contentType: "application/xml",
            url: "messageConvert/subject",
            success: function (data) {
                document.getElementById('subject').innerHTML =
                        new XMLSerializer().serializeToString(data);
            }
        });
    }
</script>
</html>
