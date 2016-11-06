<jsp:include page="header.jsp"/>


<form id="contact_form" class="form_member" action="#" method="POST" enctype="multipart/form-data">
    <div class="row">
        <br/>
        <label for="name" style="color: white">Your name:</label><br/><br/>
        <input id="name" class="input" name="name" type="text" value="" size="30"/><br/>
    </div>
    <div class="row">
        <br/>
        <label for="email" style="color: white">Your email:</label><br/><br/>
        <input id="email" class="input" name="email" type="text" value="" size="30"/><br/>
    </div>
    <div class="row">
        <br/>
        <label for="message" style="color: white">Your message:</label><br/><br/>
        <textarea id="message" class="input" name="message" rows="7" cols="30"></textarea><br/>
    </div>
    <br/>
    <input id="submit_button" type="submit" value="Send email"/>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp"/>