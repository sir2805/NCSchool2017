<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.ADD_USER.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <form action="<%=Pages.SUBJECT.ADD_SUBJECT.ADD.PATH_ABSOLUTE%>" method="post" class="form-group">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.TITLE.KEY%>"/></h2>
        <label for="subject_name" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.NAME.KEY%>"/></label>
        <input type="text" id="subject_name" name="subject_name" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.KEY%>"/>" required autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.SUBJECT.SUBMIT.KEY%>"/>
        </button>
    </form>
    <form action="<%=Pages.SUBJECT.ADD_SUBJECT.FINISH.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.FINISH.KEY%>"/>
        </button>
    </form>
</div>
