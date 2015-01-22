<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp" %>
<%@ include file="/taglib.jsp" %>
<%@ include file="/js.jsp" %>
<html>
<head>
    <title>Annotation</title>
    <script>
        var annotationModule = angular.module("annotationModule",[]);
        annotationModule.controller("modelAttrController", function($scope){
            $scope.teacher=[];
        });
    </script>
</head>
<body>
<h2>Try these annotations!</h2>
<ul>
    <li><a href="annotation/reqParam">@RequestParam</a></li>
    <li><a href="annotation/header">@RequestHeader</a></li>
    <li data-ng-app="annotationModule">@ModelAttribute
        <form action="annotation/modelAttr" method="post" data-ng-controller="modelAttrController">
            input your teacher's name:
            <label>
                <input type="text" name="name" data-ng-model="teacher.name"/><br/>
                teacher.setName({{teacher.name}})
            </label>
            <br/>
            <input type="submit">
        </form>
        <a href="annotation/modelMap">or use <strong>ModelMap</strong> instead</a>
    </li>
    <li><a href="annotation/session">@SessionAttributes</a></li>
    <li>@InitBinder</li>
    <li>@CookieValue</li>
</ul>
</body>
</html>
