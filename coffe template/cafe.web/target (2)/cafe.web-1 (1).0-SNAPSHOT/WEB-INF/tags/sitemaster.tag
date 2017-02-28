<%@tag description="Score" pageEncoding="UTF-8" %>
<%@attribute name="footer" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ variable name-given="contextPath" scope="NESTED" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Café</title>
        <script type="text/javascript" src="<c:url value='/resources/jq/jquery-1.11.3.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/bs/js/bootstrap.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/angular/angular.min.js' />"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/cafe-utils.js"></script>
        <script type="text/javascript">
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value='/resources/bs/css/bootstrap.min.css' />" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <t:validationsToHiddenInputs/>
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
                                    <a href="${contextPath}/account/create"
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
                <jsp:doBody/>
                <ul class="nav nav-tabs">
                    <li id="nav-menu-login"><a href="${contextPath}/account/login">Login</a></li>
                    <li id="nav-menu-users"><a href="${contextPath}/users/index">Users</a></li>
                    <li><a href="${contextPath}/activities/index">Activities</a></li>
                </ul>
            </div>
        </div>
        <div class="panel-footer"><small>powered by sawbonadev</small></div>
    </body>
</html>