<%@tag description="Display validations helper for kf framework" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${genericResponse != null && genericResponse.validations != null}">
    <c:forEach var="entry" items="${genericResponse.validations}">
        <c:forEach var="message" items="${entry.value}">
            <input type="hidden" id='${entry.key}' value="${message}" class="kf-generic-validation-error" />
        </c:forEach>
    </c:forEach>
</c:if>
