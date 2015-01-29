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

<p>To let <strong>@RequestBody</strong> work,
at least 1 arg in request body is needed!</p>
<p>Request with empty gonna return <strong>400</strong>.</p>
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

<p>To Json format, make sure dependencies below were declared in pom.xml:</p>
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
<p>com.kavlez.pojo.Subject instance in <a href="messageConvert/subject">xml</a></p>
<p>com.kavlez.pojo.Teacher list in <a href="messageConvert/teachers">json</a></p>

<br/>
<p>Make sure the type you want to return as xml was annotated with <code>javax.xml.bind.annotation.XmlRootElement</code></p>
<p>there are 2 methods,they were annotated with:</p>
<ul>
    <li>
        <p>@RequestMapping(value = "/subject", method = RequestMethod.GET)</p>
    </li>
    <li>
        <p>@RequestMapping(value = "/subject", method = RequestMethod.GET, produces = MediaType.APPLICATION<em>XML</em>VALUE)</p>
    </li>
</ul>
<p>when browser request with headers like ：</p>
<pre><code>Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
</code></pre>

<p>So second method was called and check converter if support these mediatypes one by one. <br>
    Find <code>MarshallingHttpMessageConverter</code> and convert Subject object into xml format.
</p>
<p>You can try to declare like below , interesting gonna happen:</p>
<pre><code>&lt;bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"&gt;
    &lt;property name="supportedMediaTypes"&gt;
    &lt;list&gt;
    &lt;value&gt;application/xml&lt;/value&gt;
    &lt;/list&gt;
    &lt;/property&gt;
    &lt;/bean&gt;</code></pre>
</body>
</html>
