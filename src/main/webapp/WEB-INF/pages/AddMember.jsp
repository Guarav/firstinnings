<jsp:include page="header.jsp" />

<form id="contact_form" method="post">
    <div class="row">
        <br />
        <label for="name" class="label" >Name:</label>
        <input id="name" required class="input" name="name" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="email" class="label">Email:</label>
        <input id="email" required class="input" name="email" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="address" class="label">Address:</label>
        <textarea id="address" required class="input" name="address" rows="7" cols="30"></textarea><br />
    </div>
    <div class="row">
        <br />
        <label for="sex" class = "label">Sex:</label>
        <select id="sex">
            <option value="">Male</option>
            <option value="">Female</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="phone" class="label">Phone Number:</label>
        <input id="phone" required class="input" name="phone" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="birth_date" class="label">Date of birth:</label>
        <input id="birth_date" required class="input datepicker" name="birth_date" type="text" placeholder="mm/dd/yyyy" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label class="label" for = "marital_status">Marital Status</label>
        <select id="marital_status">
            <option value="">Married</option>
            <option value="">Single</option>
        </select>
    </div>
    <div class="row">
        <br />
        <label for="membership_date" class="label">Membership Date:</label>
        <input id="membership_date" required class="input datepicker" name="membership_date" type="text" placeholder="mm/dd/yyyy" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="place_joining" class="label">Place of Joining:</label>
        <input id="place_joining" required class="input" name="place_joining" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="membership_months" class="label">Months of membership:</label>
        <input id="membership_months" required class="input" name="membership_months" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="amount_paid" class="label">Amount paid:</label>
        <input id="amount_paid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
    </div>

    <br />
    <input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

<a href="index.html" class="button">Home</a>

<jsp:include page="footer.jsp" />