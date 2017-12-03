<!DOCTYPE html>
<%@tag description="Score" pageEncoding="UTF-8" %>
<%@attribute name="footer" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="kf" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ variable name-given="contextPath" scope="NESTED" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <title>Café</title>
        <script type="text/javascript">
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <script type="text/javascript" src="${contextPath}/res/libs/jet/js/libs/require/require.js"></script>
        <script type="text/javascript" src="${contextPath}/res/app/main.js"></script>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value='/res/libs/jet/css/libs/oj/v2.3.0/alta/oj-alta-min.css' />" rel="stylesheet">
        <link href="<c:url value='/res/libs/bs/css/bootstrap.min.css' />" rel="stylesheet">
        <link href="<c:url value='/res/libs/fa/css/font-awesome.min.css' />" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body id="body">
        <div id="main-container">
            <div data-bind="ojModule:{name: 'header'}"></div>
            <kf:displayValidationsHelper/>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div id="body-container">
                        <div class="alert alert-danger alert-dismissible log-container" style="display:none">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong>Ooops...</strong> <span class="log-text"></span>
                        </div>
                        <jsp:doBody/>
                    </div>
                    <ul class="nav nav-tabs">
                        <li id="nav-menu-users"><a href="${contextPath}/installation/check">Check installation</a></li>
                        <li id="nav-menu-users"><a href="${contextPath}/app/projects">My Projects</a></li>
                        <li id="nav-menu-users"><a href="${contextPath}/app/publicProjects">Public Projects</a></li>
                    </ul>
                </div>
            </div>
            <div class="panel-footer"><small>powered by sawbonadev</small></div>
        </div>
    </body>
</html>