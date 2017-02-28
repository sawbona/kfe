<%@tag description="Auxiliar para mostrar errores de validacion" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${basicResponse != null && basicResponse.validations != null}">
    <c:forEach var="entry" items="${basicResponse.validations}">
        <c:forEach var="message" items="${entry.value}">
            <input type="hidden" id='${entry.key}' value="${message}" class="errorvalidacion" />
        </c:forEach>
    </c:forEach>
</c:if>
