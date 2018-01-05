<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.web.controller.SessionAttributes" %>
<%@ page import="by.nc.school.dev.entity.Person" %>
<%@ page import="by.nc.school.dev.Role" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="page">
        <h2><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TITLE.KEY%>"/></h2>
        <div class="row">
            <div class="col-md-2">
                <%
                    if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() != Role.STUDENT) {
                %>

                <h4 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_GROUP.KEY%>"/></h4>
                <form action="<%=Pages.JOURNAL.SELECT_GROUP.PATH_ABSOLUTE%>" method="post" class="form-group">
                    <div class="list-group">
                        <c:forEach var="group" varStatus="loop" items="${groups}">
                            <button type="submit" class="list-group-item list-group-item-action" name = "groupbutton" value=${group.id}>
                                    ${group.currentSemester.semesterNumber}, ${group.groupNumber}
                            </button>
                        </c:forEach>
                    </div>
                </form>

                <%--<form action="<%=Pages.JOURNAL.SELECT_GROUP.PATH_ABSOLUTE%>" method="post" class="form-group">--%>
                    <%--<h4 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_GROUP.KEY%>"/></h4>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-8">--%>
                            <%--<select class="form-control" id="group" name="group" onchange="this.form.submit()">--%>
                                <%--<option data-hidden="true"><app:app-string key="<%=AppStringsService.WEB.ADD_WORKPLAN.SELECT_GROUP.KEY%>"/></option>--%>
                                <%--<c:forEach var="group" varStatus="loop" items="${groups}">--%>
                                    <%--<option>${group.currentSemester.semesterNumber}, ${group.groupNumber}</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;<div class="col-md-4">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<button class="btn btn-lg btn-primary btn-block" type="submit">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_GROUP.BUTTON.KEY%>"/>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--</div>--%>
                <%--</form>--%>
                <%
                    }
                %>
                <form action="<%=Pages.JOURNAL.SELECT_SUBJECT.PATH_ABSOLUTE%>" method="post" class="form-group">
                    <h4 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_SUBJECT.KEY%>"/></h4>
                            <div class="list-group">
                                <c:forEach var="subject" varStatus="loop" items="${subjects}">
                                    <button type="submit" class="list-group-item list-group-item-action" name = "subjectbutton" value=${subject.id}>
                                            ${subject.name}
                                    </button>
                                    <%--<option>${subject.name}</option>--%>
                                </c:forEach>

                            <%--<select class="form-control" id="subject" name="subject" onchange="this.form.submit()">--%>
                            <%--<option data-hidden="true"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_SUBJECT.KEY%>"/></option>--%>
                            <%--<c:forEach var="subject" varStatus="loop" items="${subjects}">--%>
                            <%--<option>${subject.name}</option>--%>
                            <%--</c:forEach>--%>
                            <%--</select>--%>
                        </div>
                        <%--<div class="col-md-4">--%>
                            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">--%>
                                <%--<app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_SUBJECT.BUTTON.KEY%>"/>--%>
                            <%--</button>--%>
                        <%--</div>--%>
                </form>
            </div>
            <div class="col-md-10">
                <%
                    if (session.getAttribute(SessionAttributes.CURRENT_SUBJECT) != null) {
                %>
                <%
                    if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.CURATOR ||
                        ((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.ADMIN) {
                %>
                    <jsp:include page="add-lesson.jsp"/>
                    <jsp:include page="put-mark.jsp"/>
                <%
                }
                %>
                <h3><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TABLE.TITLE.KEY%>"/> <%=session.getAttribute(SessionAttributes.CURRENT_SUBJECT)%></h3>
                <div class="container">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TABLE.STUDENTS.KEY%>"/></th>
                            <c:forEach var="lesson" varStatus="loop" items="${lessons}">
                                <th scope="col">${lesson}</th>
                            </c:forEach>
                            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TABLE.AVERAGE_MARK.KEY%>"/></th>
                        </tr>
                        </thead>
                        <c:forEach var="lessonAndMarks" varStatus="loop" items="${lessonsAndMarks}">
                            <tbody>
                            <tr>
                                <th scope="row">${students[loop.index].fullname}</th>
                                <c:forEach var="mark" varStatus="loop" items="${lessonAndMarks}">
                                    <td>${mark}</td>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
                <%
                    }
                %>
            </div>

        </div>
    </div>
</body>