<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />


<div style="margin-top:10%">
    <c:forEach items="${roles}" var="role">

        <a href="/${role.name}" class="role">${role.displayText}</a>

    </c:forEach>
</div>




<a href="/Writetous" class="button1">Write to Us</a>

<jsp:include page="footer.jsp" />