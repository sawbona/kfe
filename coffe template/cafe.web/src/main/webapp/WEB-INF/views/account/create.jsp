<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <script src="${contextPath}/res/app/users/create.js"></script>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <form action="${contextPath}/account/create" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>
                                Email <span class="text-muted">(required)</span>
                            </label>
                            <div class="input-group">
                                <input type="email" class="form-control" name="email" id='email' value="${genericResponse.payload.email}"/>
                                <span class="input-group-addon glyphicon glyphicon-envelope"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container email has-error"></div>
                            <div class="cafe-error-container duplicatedEmail has-error"></div>
                            <div class="cafe-show-on-error duplicatedEmail hidden text-info">
                                Forgot your password? <a href="../account/resetpassword">Follow this link.</a>
                            </div>
                            </p>
                            <span class="help-block">Enter a valid email address.</span>
                        </div>
                        <div class="form-group">
                            <label>
                                Password <span class="text-muted">(required)</span>
                            </label>
                            <div class="input-group">
                                <input type="password" class="form-control" name="password" value="${genericResponse.payload.password}" />
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container password has-error"></div>
                            <div class="cafe-error-container passwordInsecure has-error"></div>
                            <div class="cafe-error-container passwordNotMatch has-error"></div>
                            </p>
                            <span class="help-block">8 characters, one capital letter, one lower case letter and a special caracter at least.</span>
                        </div>
                        <div class="form-group">
                            <label>
                                Confirm your password <span class="text-muted">(required)</span>
                            </label>
                            <div class="input-group">
                                <input type="password" class="form-control" name="passwordConfirm" value='${genericResponse.payload.passwordConfirm}' />
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                            <p>
                            <div class="cafe-error-container passwordConfirm has-error"></div>
                            <div class="cafe-error-container passwordNotMatch has-error"></div>
                            </p>
                            <span class="help-block">Re-enter your password.</span>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-primary">Create account</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</t:sitemaster>