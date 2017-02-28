<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <form>
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div class="form-group">
                            <label>
                                Usuario
                            </label>
                            <input type="text" class="form-control" name="usuario" id="usuario" />
                        </div>
                        <div class="form-group">
                            <label>
                                Contraseña
                            </label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="password" />
                                <span class="input-group-addon glyphicon glyphicon-lock"></span>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-primary">Iniciar sesión</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $(function(){
            $("#usuario").focus();
        });
    </script>
</t:sitemaster>