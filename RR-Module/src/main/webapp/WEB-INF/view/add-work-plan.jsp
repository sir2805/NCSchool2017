<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.web.controller.SessionAttributes" %>
<%@ page import="by.nc.school.dev.entity.TutorAndSubject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="form-add">
    <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.TITLE.KEY%>"/></h2>
    <%
        if (session.getAttribute(SessionAttributes.CHOSEN_GROUP_INFO) == null) {
    %>
    <form action="<%=Pages.WORKPLAN.ADD_WORKPLAN.PATH_ABSOLUTE%>" method="post" class="form-group">
        <jsp:include page="select-group.jsp"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name = "select-group" value="selectGroup">
            <app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.SELECT_GROUP.SELECT.KEY%>"/>
        </button>
    </form>
    <%
        } else {
    %>
    <form action="<%=Pages.WORKPLAN.ADD_WORKPLAN.PATH_ABSOLUTE%>" method="post" class="form-group">
        <h3 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.ITEM.KEY%>"/></h3>
        <div class="row">
            <div class="col-md-6">
                <label for="subjectname"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.ITEM.SUBJECT.KEY%>"/></label>
                <select class="form-control" id="subjectname" name="subjectname" aria-hidden="true">
                <c:forEach var="subject" varStatus="loop" items="${subjects}">
                    <option>${subject.name}</option>
                </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <label for="tutorname"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.ITEM.TUTOR.KEY%>"/></label>
                <select class="form-control" id="tutorname" name="tutorname" aria-hidden="true">
                <c:forEach var="tutor" varStatus="loop" items="${tutors}">
                    <option>${tutor.fullname}</option>
                </c:forEach>
                </select>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name = "add-item" value="addItem">
            <app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.ITEM.ADDITEM.KEY%>"/>
        </button>
        <%
            if (((List<TutorAndSubject>)session.getAttribute(SessionAttributes.CURRENTLY_ADDING_WORK_PLAN)).size() != 0) {
        %>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name = "add-plan" value="addPlan">
            <app:app-string key="<%=AppStringsService.WEB.ADD_SUBJECT.FINISH.KEY%>"/>
        </button>
        <%
            }
        %>
    </form>
    <%
        }
    %>
</div>
</body>
</html>