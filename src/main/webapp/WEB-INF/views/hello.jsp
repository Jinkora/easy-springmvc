<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp"%>
<%@ include file="/taglib.jsp"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>Yep! This is hello.jsp</h2>
Here is message from HelloController: <strong>${message}</strong>
<p>Everything goes well , check <code>web.xml</code></p>
<pre><code>&lt;servlet&gt;
    &lt;servlet-name&gt;dispatcher&lt;/servlet-name&gt;
    &lt;servlet-class&gt;org.springframework.web.servlet.DispatcherServlet&lt;/servlet-class&gt;
    &lt;init-param&gt;
        &lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;
        &lt;param-value&gt;/WEB-INF/spring-mvc.xml&lt;/param-value&gt;
    &lt;/init-param&gt;
    &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
&lt;/servlet&gt;
&lt;servlet-mapping&gt;
    &lt;servlet-name&gt;dispatcher&lt;/servlet-name&gt;
    &lt;url-pattern&gt;/&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;</code></pre>
<br/>
<p>Declare Controller with <code>@Controller</code>,so I
    annotate HelloController with @Controller,check configuration in <code>spring-mvc.xml</code>,only <code>@Controller</code> is allowed :</p>
<pre><code>&lt;context:component-scan base-package="com.kavlez.controller" use-default-filters="false"&gt;
    &lt;context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/&gt;
&lt;/context:component-scan&gt;</code></pre>
</body>
</html>
