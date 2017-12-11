<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.HOME.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TITLE.KEY%>"/></h2>
    <form action="<%=Pages.GROUP.INIT_GROUP.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.INIT.TITLE.KEY%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/></label>
        <input type="number" id="groupnumber" name="groupnumber" class="form-control" required autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.INIT.SUBMIT.KEY%>"/>
        </button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.USERNAME.KEY%>"/></th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.PASSWORD.KEY%>"/></th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.TABLE.FULLNAME.KEY%>"/></th>
        </tr>
        </thead>
        <c:forEach var="student" varStatus="loop" items="${students}">
            <tbody>
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${student.username}</td>
                <td>${student.password}</td>
                <td>${student.person.fullname}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <form action="<%=Pages.GROUP.ADD_GROUP_MEMBER.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.NEW_USER.TITLE.KEY%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/>" required autofocus>
        <label for="password" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/>" required>
        <label for="fullname" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.FULLNAME.KEY%>"/></label>
        <input type="text" id="fullname" name="fullname" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.ADD_USER.PERSON.FULLNAME.KEY%>"/>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.NEW_USER.SUBMIT.KEY%>"/>
        </button>
    </form>
    <form action="<%=Pages.GROUP.ADD_GROUP.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.ADD_GROUP.CREATE.KEY%>"/>
        </button>
    </form>
</div>
</body>
</html>
