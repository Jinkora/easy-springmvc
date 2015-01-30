<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<%@ include file="/js.jsp" %>
<html>
<head>
    <title>URL Pattern Sample</title>
</head>
<body>
<h2>Bind data in URL</h2>

<div data-ng-app="">
    <ul>
        <li>Only 1 param is allowed:<br/>
            <table>
                <tr>
                    <td>username:</td>
                    <td><input type="text" data-ng-model="username"/></td>
                </tr>
            </table>
            <a href="urlPattern/path/user/{{username}}">urlPattern/path/user/{{username}}</a>
            <br/><br/></li>
        <li>Must be 2 params:
            <table>
                <tr>
                    <td>uname:</td>
                    <td><input type="text" data-ng-model="uname"/></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input type="text" data-ng-model="password"/></td>
                </tr>
                <br/>
            </table>
            <a href="urlPattern/auth/user/{{uname}}/pass/{{password}}">urlPattern/auth/user/{{uname}}/pass/{{password}}</a>
            <br/><br/></li>
        <li>RegExp is also supported,try 6 digits:<br/>
            <table>
                <tr>
                    <td>digit6:</td>
                    <td><input type="text" data-ng-model="digit6"/></td>
                </tr>
            </table>

            <a href="urlPattern/reg/{{digit6}}">urlPattern/reg/{{digit6}}</a><br/><br/></li>

        <li>Let's try Matrix variable.<br/>

            <p>How to enable matrix?</p>
            <pre><code>&lt;mvc:annotation-driven enable-matrix-variables="true"/&gt;</code></pre>

            <table>
                <tr>
                    <td>client:</td>
                    <td><input type="text" data-ng-model="client"/></td>
                </tr>
                <tr>
                    <td>age:</td>
                    <td><input type="text" data-ng-model="age"/></td>
                </tr>
            </table>
            <a href="urlPattern/matrix/{{client}};age={{age}}">urlPattern/matrix/{{client}};age={{age}}</a><br/>
            <br/><br/></li>
        <li>Matrix variable could be optional:<br/>
            <table>
                <tr>
                    <td>client_:</td>
                    <td><input type="text" data-ng-model="client_"/></td>
                </tr>
                <tr>
                    <td>age_:</td>
                    <td><input type="text" data-ng-model="age_"/></td>
                </tr>
                <tr>
                    <td>height_:</td>
                    <td><input type="text" data-ng-model="height_"/></td>
                </tr>
            </table>

            <a href="urlPattern/matrix_/{{client_}};age={{age_}};height={{height_}}">urlPattern/matrix_/{{client_}};age={{age_}};height={{height_}}</a>
            <br/><br/></li>
        <li>Matrix variables in a map:<br/>
            <table>
                <tr>
                    <td>tneilc:</td>
                    <td><input type="text" data-ng-model="tneilc"/></td>
                </tr>
                <tr>
                    <td>ega:</td>
                    <td><input type="text" data-ng-model="ega"/></td>
                </tr>
                <tr>
                    <td>thgieh:</td>
                    <td><input type="text" data-ng-model="thgieh"/></td>
                </tr>
            </table>

            <a href="urlPattern/xirtam/{{tneilc}};age={{ega}};height={{thgieh}}">urlPattern/xirtam/{{tneilc}};age={{ega}};height={{thgieh}}</a>
            <br/><br/></li>
        <li>
            Don't like Matrix pattern? Customize a converter.<br/>


            <p>First, declare an implemenets class of <strong>org.springframework.core.convert.converter.Converter</strong></p>
            <p>then override </p>
            <pre><code>T convert(S source);</code></pre>
            <p>then specify in spring-mvc.xml</p>
<pre><code>&lt;bean id="convertionService" class="org.springframework.context.support.ConversionServiceFactoryBean"&gt;
    &lt;property name="converters"&gt;
    &lt;set&gt;
    &lt;bean class="com.kavlez.converter.TeacherConverter"/&gt;
    &lt;/set&gt;
    &lt;/property&gt;
&lt;/bean&gt;</code></pre>

            <p>try it:</p>
            <label>
                <input type="text" ng-model="teacherName"/>
            </label>
            <br/>
            <a href="urlPattern/convert?teacher={{teacherName}}">urlPattern/convert?teacher={{teacherName}}</a>
        </li>
    </ul>
</div>
<br/>
</body>

</html>
