<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<%@ include file="/js.jsp" %>
<html>
<head>
    <title>multipart support</title>
</head>
<body>
<h2>multipart support</h2>

<p><br>
    Post image file to <code>com.kavlez.controller.MultipartController.headImag</code></p>
<form action="multiPart/image" enctype="multipart/form-data" method="post">
    <input type="file" name="image"/>
    <input type="submit"/>
</form>
<br/>
<p>To make spring mvc support multipart message, the only thing you should do is declaring CommonsMultipartResolver in your config file.</p>
<p>e.g.</p>
<pre><code>&lt;!-- support multipart type content --&gt;
&lt;bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"&gt;
    &lt;property name="maxUploadSize" value="1000000"/&gt;
&lt;/bean&gt;</code></pre>
<br/>
<p>Enjoy! Here is a sample below.</p>
<pre><code>public byte[] headImage(@RequestParam MultipartFile image) throws IOException {
    return image.getBytes();
}</code></pre>
</body>
</html>
