<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <form action="${contextPath}/account/create" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>
                                Email <span class="text-muted">(requerido)</span>
                            </label>
                            <div class="input-group">
                                <input type="email" class="form-control" name="email" id='email' value="${basicResponse.view.email}"/>
                                <span class="input-group-addon glyphicon glyphicon-envelope"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container email has-error"></div>
                            <div class="cafe-error-container duplicatedEmail has-error"></div>
                            <div class="cafe-show-on-error duplicatedEmail hidden text-info">
                                Forgot your password? <a href="../account/resetpassword">Follow this link.</a>
                            </div>
                            </p>
                            <span class="help-block">Ingrese un correo electrónico.</span>
                        </div>
                        <div class="form-group">
                            <label>
                                Contraseña <span class="text-muted">(requerido)</span>
                            </label>
                            <div class="input-group">
                                <input type="password" class="form-control" name="password" value="${basicResponse.view.password}" />
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container password has-error"></div>
                            <div class="cafe-error-container passwordInsecure has-error"></div>
                            <div class="cafe-error-container passwordNotMatch has-error"></div>
                            </p>
                            <span class="help-block">Al menos 8 caracteres, una mayúscula, una minúscula y al menos un caracter especial.</span>
                        </div>
                        <div class="form-group">
                            <label>
                                Confirma tu contraseña <span class="text-muted">(requerido)</span>
                            </label>
                            <div class="input-group">
                                <input type="password" class="form-control" name="passwordConfirm" value='${basicResponse.view.passwordConfirm}' />
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container passwordConfirm has-error"></div>
                            <div class="cafe-error-container passwordNotMatch has-error"></div>
                            </p>
                            <span class="help-block">Repite la contraseña del campo anterior.</span>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-primary">Create account</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            $("#email").focus();
            $(".error-container").addClass("hide");
            $(".error-container").each(function () {
                $(this).text("");
            });

        });
    </script>
</t:sitemaster>