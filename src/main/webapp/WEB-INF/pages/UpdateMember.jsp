<jsp:include page="header.jsp" />

<p class="search"> Search by</p>

    <form id="contact_form" action="hello.jsp" method="POST" enctype="multipart/form-data">
<div class="row">
    <br /><br  /><br />
    <label for="name" style="color: white">Name:</label><br /><br />
    <input id="name" class="input" name="name" type="text" value="" size="30" /><br /><br />
</div>

<p class="or"> OR </p>

<div class="row">
     <br />
     <label for="phone" style="color: white">Phone Number:</label><br /><br />
     <input id="phone" class="input" name="phone" type="text" value="" size="30" /><br />
</div>

<br />
<input id="submit_button" type="submit" value="Update" style="font-size: 100%"/>
</form>

    <a href="index.html" class="button">Home</a>

<jsp:include page="footer.jsp" />