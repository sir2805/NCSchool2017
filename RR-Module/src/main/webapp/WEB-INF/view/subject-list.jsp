<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2><app:app-string key="<%=AppStringsService.WEB.SUBJECT.LIST.KEY%>"/></h2>
    <ul style="list-style-type:circle" aria-hidden="true">
        <h4>
        <c:forEach var="subject" varStatus="loop" items="${subjects}">
            <li>${subject.name}</li>
        </c:forEach>
        </h4>
    </ul>
