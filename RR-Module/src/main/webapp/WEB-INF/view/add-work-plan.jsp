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

<div class="container">
    <form action="<%=Pages.WORKPLAN.ADD_WORKPLAN.PATH_ABSOLUTE%>" method="post" class="form-group">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.TITLE.KEY%>"/></h2>
        <jsp:include page="select-group.jsp"/>
        <div class="row">
            <div class="col-md-6">
                <select class="form-control" id="subject" name="subject" aria-hidden="true">
                <c:forEach var="subject" varStatus="loop" items="${subjects}">
                    <option>${subject.name}</option>
                </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <select class="form-control" id="tutor" name="tutor" aria-hidden="true">
                <c:forEach var="tutor" varStatus="loop" items="${tutors}">
                    <option>${tutor.fullname}</option>
                </c:forEach>
                </select>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_USER.SUBMIT.KEY%>"/>
        </button>
    </form>
</div>
</body>
</html>