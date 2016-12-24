<jsp:include page="header.jsp" />

<form id="contact_form" class="form_member" method="post" action="/Enquiry">

    <div class="row">
        <br />
        <label for="name" class="label_form" >Name:</label>
        <input id="name" required class="input" name="name" type="text" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="email" class="label_form">Email:</label>
        <input id="email" class="input" name="email" type="text" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="address" class="label_form">Address:</label>
        <textarea id="address" class="input" name="address" rows="7" cols="30"></textarea><br />
    </div>
    <div class="row">
        <br />
        <label for="sex" class = "label_form">Sex:</label>
        <select id="sex" name="sex" required class="input">
            <option disabled value="" selected="selected">Select:</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="phone" class="label_form">Phone Number:</label>
        <input id="phone" required class="input" name="phone" type="text" value="" size="30" /><br />
    </div>

    <div class="row">
        <br />
        <label for="source" class = "label_form">Source:</label>
        <select id="source" name="source" required class="input">
            <option disabled value="" selected="selected">Select:</option>
            <option value="internet">Internet</option>
            <option value="phone">Phone</option>
            <option value="friend">Friend</option>
            <option value="advertisement">Advertisement</option>
            <option value="others">Others</option>
        </select>
    </div>

    <br />
    <br />
    <jsp:include page="elements/button.jsp">
        <jsp:param name="text" value="Save & Continue" />
    </jsp:include>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />