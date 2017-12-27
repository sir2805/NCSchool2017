<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.entity.Person" %>
<%@ page import="by.nc.school.dev.web.controller.SessionAttributes" %>
<%@ page import="by.nc.school.dev.Role" %>
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
    <%
        if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.DEAN ||
                ((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.ADMIN) {
    %>
    <div class="page">
        <h2><app:app-string key="<%=AppStringsService.WEB.ANALYSIS.STUDENTS_WITH_BAD_AVERAGE_MARK.KEY%>"/></h2>
        <ul style="list-style-type:circle" aria-hidden="true">
            <h4>
                <c:forEach var="studentinfo" varStatus="loop" items="${studentsinfo}">
                    <li>${studentinfo}</li>
                </c:forEach>
            </h4>
        </ul>
    </div>
    <%
        }
    %>
</body>
</html>