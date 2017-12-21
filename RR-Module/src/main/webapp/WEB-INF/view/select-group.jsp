<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<label for="group"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.SELECT_GROUP.SELECT.KEY%>"/></label>
<select class="form-control" id="group" name="group" aria-hidden="true">
    <c:forEach var="group" varStatus="loop" items="${groups}">
        <option>${group.currentSemester.semesterNumber}, ${group.groupNumber}</option>
    </c:forEach>
</select>
