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

<p>Let's <strong>@RequestBody</strong> works.</p>
<p>At least 1 param in request body is needed!</p>
<p>Request with nothing gonna return <strong>400</strong>.</p>
<div>
    <form method="post" action="messageConvert/body">
        <p>Submit with nothing in request body.</p>
        <input type="submit"/>
    </form>
    <form method="post" action="messageConvert/body">
        <p>Submit with something, value could be empty.</p>
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

<p>For Json format, make sure dependencies below were declared in pom.xml:</p>
<pre>
<code>&lt;dependency&gt;
    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
    &lt;artifactId&gt;jackson-core&lt;/artifactId&gt;
    &lt;version&gt;${com.fasterxml.jackson.core}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
    &lt;artifactId&gt;jackson-databind&lt;/artifactId&gt;
    &lt;version&gt;${com.fasterxml.jackson.core}&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
    &lt;artifactId&gt;jackson-annotations&lt;/artifactId&gt;
    &lt;version&gt;${com.fasterxml.jackson.core}&lt;/version&gt;
&lt;/dependency&gt;</code></pre>
<p>
    com.kavlez.pojo.Subject instance in <a href="messageConvert/subject">xml</a>
</p>
<br/>
<p>Make sure the Type you want to return as xml was annotated with <code>javax.xml.bind.annotation.XmlRootElement</code></p>
<p>
    com.kavlez.pojo.Teacher list in <a href="messageConvert/teachers">json</a>
</p>

</body>

</html>
