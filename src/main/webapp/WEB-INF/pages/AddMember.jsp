<jsp:include page="header.jsp" />


<form id="contact_form" action="hello.jsp" method="POST" enctype="multipart/form-data">
    <div class="row">
        <br />
        <label for="name" style="color: white">Name:</label>
        <input id="name" required class="input" name="name" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="email" style="color: white">Email:</label>
        <input id="email" required class="input" name="email" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="address" style="color: white">Address:</label>
        <textarea id="address" required class="input" name="address" rows="7" cols="30"></textarea><br />
    </div>
    <div class="row">
        <br />
        <label class="sex" for = "sex" style="color: white">Sex:</label>
        <select>
            <option value="">Male</option>
            <option value="">Female</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="phone" style="color: white">Phone Number:</label>
        <input id="phone" required class="input" name="phone" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="birth_date" style="color: white">Date of birth:</label>
        <input id="datepicker" required class="input" name="birth_date" type="text" value="mm/dd/yyyy" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label class="marital_status" for = "marital_status" style="color: white">Sex:</label>
        <select>
            <option value="">Married</option>
            <option value="">Single</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="membership_date" style="color: white">Membership Date:</label>
        <input id="datepicker" required class="input" name="membership_date" type="text" value="mm/dd/yyyy" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="place_joining" style="color: white">Place of Joining:</label>
        <input id="place_joining" required class="input" name="place_joining" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="membership_months" style="color: white">Months of membership:</label>
        <input id="membership_months" required class="input" name="membership_months" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="amount_paid" style="color: white">Amount paid:</label>
        <input id="amount_paid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
    </div>

    <br />
    <input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

<a href="index.html" class="button">Home</a>

<jsp:include page="footer.jsp" />