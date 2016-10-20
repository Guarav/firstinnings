<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />



<form id="contact_form" method="POST">
    <div class="row">
        <br />
        <label for="name" style="color: white">Name:</label><br /><br />
        <input id="name" required class="input" name="phone" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="membership_id" style="color: white">Membership ID:</label><br /><br />
        <input id="membership_id" required class="input" name="membership_id" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
    <br />
    <label for="renewal_date" style="color: white">Renewal Date:</label><br /><br />
    <input id="renewal_date" required class="input" name="renewal_date" type="date" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="renewal_months" style="color: white">Months of renewal:</label><br /><br />
        <input id="renewal_months" required class="input" name="renewal_months" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="amount_paid" style="color: white">Amount paid</label><br /><br />
        <input id="amount_paid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
    </div>

    <br />
    <input id="submit_button" type="submit" value="Update" style="font-size: 100%"/>
</form>

<c:if test="${!empty member }">
    <h1>${member}</h1>
</c:if>

<a href="index.html" class="button">Home</a>

<jsp:include page="footer.jsp" />