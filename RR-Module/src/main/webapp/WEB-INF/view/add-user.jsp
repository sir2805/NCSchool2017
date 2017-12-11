<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><app:app-string key="<%=AppStringsService.WEB.ADD_USER.TITLE.KEY%>"/></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="/static/style.css">
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    </head>
</head>
<body>
<div class="container">
    <form action="<%=Pages.USER.NEW_USER.PATH_ABSOLUTE%>" method="post" class="form-group">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.TITLE.KEY%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/>" required autofocus>
        <label for="password" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/>" required>
        <label for="fullname" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.FULLNAME.KEY%>"/></label>
        <input type="text" id="fullname" name="fullname" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.FULLNAME.KEY%>"/>">
        <label for="role"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.KEY%>"/></label>
        <select class="form-control" id="role" name="role">
            <option><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY%>"/></option>
            <option><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.TUTOR.KEY%>"/></option>
            <option><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.CURATOR.KEY%>"/></option>
            <option><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.DEAN.KEY%>"/></option>
            <option><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.ROLE.ADMIN.KEY%>"/></option>
        </select>
        <label for="group"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.GROUP.KEY%>"/></label>
        <select class="form-control" id="group" name="group" aria-hidden="true">
            <c:forEach var="group" varStatus="loop" items="${groups}">
                <option>${group.currentSemester.semesterNumber}, ${group.groupNumber}</option>
            </c:forEach>
        </select>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_USER.SUBMIT.KEY%>"/>
        </button>
    </form>
</div>
</body>
</html>
