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
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <title>Café</title>
        <script type="text/javascript">
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <script type="text/javascript" src="${contextPath}/res/jet/js/libs/require/require.js"></script>
        <script type="text/javascript" src="${contextPath}/res/mainApp.js"></script>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value='/res/jet/css/libs/oj/v2.3.0/alta/oj-alta-min.css' />" rel="stylesheet">
        <link href="<c:url value='/res/bs/css/bootstrap.min.css' />" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <kf:displayValidationsHelper/>
        <div class="panel panel-default">
            <div class="panel-body">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${contextPath}">Café</a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li><a href="${contextPath}/acercade/index.jsp">How does it work?</a></li>
                            </ul>
                            <form class="navbar-form navbar-left" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="¿Qué estás buscando?">
                                </div>
                                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="${contextPath}/account/login"
                                       role="button" 
                                       aria-haspopup="true" 
                                       aria-expanded="false">
                                        Iniciar sesión
                                    </a>
                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
                <div id="body-container">
                    <div class="alert alert-danger alert-dismissible log-container" style="display:none">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        <strong>Ooops...</strong> <span class="log-text"></span>
                    </div>
                    <div>
                        
                    </div>
                    <jsp:doBody/>
                </div>
                <ul class="nav nav-tabs">
                    <li id="nav-menu-login"><a href="${contextPath}/account/login">Login</a></li>
                    <li id="nav-menu-users"><a href="${contextPath}/users/admin">Users</a></li>
                    <li id="nav-menu-users"><a href="${contextPath}/projects/">Projects</a></li>
                    <li><a href="${contextPath}/activities/index">Activities</a></li>
                </ul>
            </div>
        </div>
        <div class="panel-footer"><small>powered by sawbonadev</small></div>
    </body>
</html>