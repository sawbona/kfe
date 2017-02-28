<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:csrfMetaTags /> 
<t:sitemaster>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form action="${contextPath}/login" method="post">
                
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <!--<input type="text" name="_csrf" value="7c331c0f-ee9d-43fd-bb56-c317831a6d0c"/>-->
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>
                                Email <span class="text-muted">(requerido)</span>
                            </label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="username"/>
                                <span class="input-group-addon glyphicon glyphicon-envelope"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>
                                Contraseña <span class="text-muted">(requerido)</span>
                            </label>
                            <div class="input-group">
                                <input type="password" class="form-control" name="password"/>
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                        </div>

                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-primary">Ingresar</button>
                        <a class="btn pull-right" href="../account/create">Create account instead?</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        
    </script>
</t:sitemaster>