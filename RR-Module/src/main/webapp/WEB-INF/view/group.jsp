<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2><app:app-string key="<%=AppStringsService.WEB.HOME.TITLE.KEY%>"/></h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.GROUP.TABLE.STUDENT.KEY%>"/></th>
        </tr>
        </thead>
        <c:forEach var="student" varStatus="loop" items="${students}">
            <tbody>
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${student.fullname}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
