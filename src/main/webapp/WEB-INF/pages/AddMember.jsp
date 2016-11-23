<jsp:include page="header.jsp" />

<form id="contact_form" class="form_member" method="post" action="/addAMember">

    <jsp:include page="memberDetails.jsp" />

    <br />
    <input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />