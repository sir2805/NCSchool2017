<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.USERNAME.KEY%>"/></th>
        <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.PASSWORD.KEY%>"/></th>
        <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.FULLNAME.KEY%>"/></th>
    </tr>
    </thead>
    <c:forEach var="user" varStatus="loop" items="${users}">
        <tbody>
        <tr>
            <th scope="row">${loop.index+1}</th>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.person.fullname}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>