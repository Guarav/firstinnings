<jsp:include page="header.jsp" />

<form id="contact_form" class="form_member" method="post" action="/Enquiry">

    <div class="row">
        <br />
        <label for="name" class="label_form" >Name:</label>
        <input id="name" required class="input" name="name" type="text" data-ng-model="member.name" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="email" class="label_form">Email:</label>
        <input id="email" name="email" type="text" data-ng-model="member.email" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="address" class="label_form">Address:</label>
        <textarea id="address" name="address" data-ng-model="member.address" rows="7" cols="30"></textarea><br />
    </div>
    <div class="row">
        <br />
        <label for="sex" class = "label_form">Sex:</label>
        <select data-ng-model="member.sex" id="sex" name="sex" required class="input">
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="phone" class="label_form">Phone Number:</label>
        <input id="phone" data-ng-model="member.phone" required class="input" name="phone" type="text" value="" size="30" /><br />
    </div>

    <div class="row">
        <br />
        <label for="source" class = "label_form">Source:</label>
        <select data-ng-model="member.source" id="source" name="source" required class="input">
            <option value="Internet">Internet</option>
            <option value="Phone">Phone</option>
            <option value="Friend">Friend</option>
            <option value="Advertisement">Advertisement</option>
            <option value="Others">Others</option>
        </select>
    </div>

    <br />
    <input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />