<jsp:include page="header.jsp" />


    <form id="contact_form" action="hello.jsp" method="POST" enctype="multipart/form-data">
<div class="row">
    <br />
    <label for="name" style="color: white">Name:</label><br /><br />
    <input id="name" required class="input" name="name" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="email" style="color: white">Email:</label><br /><br />
    <input id="email" required class="input" name="email" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="address" style="color: white">Address:</label><br /><br />
    <textarea id="address" required class="input" name="address" rows="7" cols="30"></textarea><br />
</div>
<div class="row">
     <br />
     <label for="sex" style="color: white">Sex:<br /><br />
        <input type="radio" name="sex" value="male" checked /> Male<br />
        <input type="radio" name="sex" value="female" /> Female<br />
        <input type="radio" name="sex" value="other" /> Other<br />
     </label>
</div>
<div class="row">
    <br />
    <label for="phone" style="color: white">Phone Number:</label><br /><br />
     <input id="phone" required class="input" name="phone" type="text" value="" size="30" /><br />
</div>
<div class="row">
     <br />
     <label for="birth_date" style="color: white">Date of birth:</label><br /><br />
     <input id="birth_date" required class="input" name="birth_date" type="date" value="" size="30" /><br />
</div>
<div class="row">
     <br />
     <label for="membership_date" style="color: white">Membership Date:</label><br /><br />
     <input id="membership_date" required class="input" name="membership_date" type="date" value="" size="30" /><br />
</div>
<div class="row">
     <br />
     <label for="place_joining" style="color: white">Place of Joining:</label><br /><br />
     <input id="place_joining" required class="input" name="place_joining" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="membership_months" style="color: white">Months of membership:</label><br /><br />
    <input id="membership_months" required class="input" name="membership_months" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="amount_paid" style="color: white">Amount paid</label><br /><br />
    <input id="amount_paid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
</div>

<br />
<input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

    <a href="index.html" class="button">Home</a>

<jsp:include page="footer.jsp" />