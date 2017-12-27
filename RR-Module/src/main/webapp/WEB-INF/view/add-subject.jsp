<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="<%=Pages.SUBJECT.ADD_SUBJECT.ADD.PATH_ABSOLUTE%>" method="post" class="form-add">
    <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.TITLE.KEY%>"/></h2>
    <label for="subject_name" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.NAME.KEY%>"/></label>
    <input type="text" id="subject_name" name="subject_name" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.KEY%>"/>" required autofocus>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        <app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.SUBMIT.KEY%>"/>
    </button>
</form>

