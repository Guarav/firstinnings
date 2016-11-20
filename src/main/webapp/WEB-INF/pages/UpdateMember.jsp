<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<p class="search"> Search by</p>

<form id="contact_form" class="form_member" method="GET" action="/searchMember">
    <div class="row">
        <br/><br/><br/>
        <label for="name" style="color: white">Name:</label><br/>
        <input id="name" class="input" name="name" type="text" value="" size="30"/><br/>
    </div>

    <p class="or"> OR </p>

    <div class="row">
        <br/><br/><br/><br/>
        <label for="phone" style="color: white">Phone Number:</label><br/>
        <input id="phone" class="input" name="phone" type="text" value="" size="30"/><br/>
    </div>

    <br/><br/>
    <input id="submit_button" type="submit" value="Search" style="font-size: 100%"/>
</form>
${member}
<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp"/>