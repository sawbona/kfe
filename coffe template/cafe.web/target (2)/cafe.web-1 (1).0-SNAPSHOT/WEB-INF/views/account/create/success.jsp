<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <div class="well">
        <h2>Registro exitoso</h2>
        <p>
            Se le ha enviado un correo electrónico con las instrucciones para 
            finalizar su registro.
        </p>
        <p>
            Si no recibe el correo en los próximos minutos por favor contacte 
            con el administrador del sitio.
        </p>
        <a href="${contextPath}">
            Regresar
        </a>
    </div>
</t:sitemaster>