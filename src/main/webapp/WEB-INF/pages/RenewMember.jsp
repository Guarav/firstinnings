<!DOCTYPE html>
<html>
<style>
    body {
        background-image: url("https://s16.postimg.org/6ufcbft5h/Running1.jpg") ;
        background-repeat: no-repeat;
        background-size: cover;
        background-attachment: fixed;
    }

    form {

        position: absolute;
        /*top: 0px;*/
        left: 500px;
    }

    .button {
        position: absolute;
        top: 10px;
        left: 10px;
        padding:10px;
        background-color: antiquewhite;
        color: black;;
        text-decoration:none;
        border-radius: 10px;
    }

</style>

<body>


<form id="contact_form" action="hello.jsp" method="POST" enctype="multipart/form-data">
    <div class="row">
        <br />
        <label for="name" style="color: white">Name:</label><br /><br />
        <input id="name" required class="input" name="name" type="text" value="" size="30" /><br />
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

<a href="index.html" class="button">Home</a>

</body>
</html>