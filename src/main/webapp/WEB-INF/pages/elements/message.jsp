<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${ !empty message and !empty message.status and message.status == 'SUCCESS' }">

        <div class="message a-box a-alert a-alert-success">
            <div class="a-box-inner a-alert-container">
                <i class="a-icon a-icon-alert"></i>
                <div class="a-alert-content">${message.message}</div>
            </div>
        </div>

    </c:when>
    <c:when test="${ !empty message and !empty message.status and message.status == 'ERROR'}" >

        <div class="message a-box a-alert a-alert-error">
            <div class="a-box-inner a-alert-container">
                <i class="a-icon a-icon-alert"></i>
                <div class="a-alert-content">${message.message}</div>
            </div>
        </div>

    </c:when>
    <c:when test="${ !empty message and !empty message.status and message.status == 'INFO'}" >

        <div class="message a-box a-alert a-alert-info">
            <div class="a-box-inner a-alert-container">
                <i class="a-icon a-icon-alert"></i>
                <div class="a-alert-content">${message.message}</div>
            </div>
        </div>

    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>
