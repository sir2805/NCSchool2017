<%@ page import="by.nc.school.dev.web.Pages" %>
<%@ page import="by.nc.school.dev.service.AppStringsService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="<%=Pages.USER.NEW_USER.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.HOME.NEW_USER.TITLE.KEY%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/>" required autofocus>
        <label for="countries" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.HOME.NEW_USER.PERSON.KEY%>"/></label>
        <input type="text" id="countries" name="countries" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.HOME.NEW_USER.PERSON.KEY%>"/>">
        <label for="password" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/>" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.HOME.NEW_USER.SUBMIT.KEY%>"/>
        </button>
    </form>
</div>
</body>
</html>
