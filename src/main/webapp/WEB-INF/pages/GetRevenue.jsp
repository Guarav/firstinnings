<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

${totalRevenue}
<form class="form_member" method="POST" action="/getRevenue">
    <c:if test="${not empty totalRevenue}">
        Total Revenue by ${revenueBy}: ${totalRevenue} <br>
    </c:if>
    <select id="revenueBy" name="revenueBy">
        <option disabled value="">Get Revenue By:</option>
        <option value="Weekly">Weekly</option>
        <option value="Monthly">Monthly</option>
        <option value="Yearly">Yearly</option>
    </select>
    <input class="input" type="submit" value="Get Revenue" size="30"/><br/>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp"/>