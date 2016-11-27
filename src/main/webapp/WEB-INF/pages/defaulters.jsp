<%--
  Created by IntelliJ IDEA.
  User: poplig
  Date: 11/27/16
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<c:forEach items="${defaulters}" var="member">
    <tr>
        <td>Employee ID: <c:out value="${member.name}"/></td>
    </tr>
</c:forEach>


