<!DOCTYPE html>
<html>
<style>
    body {
        background-image: url("https://s16.postimg.org/6ufcbft5h/Running1.jpg") ;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        background-attachment: scroll;
    }

    form {

        position: relative;
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
    <input id="name" class="input" name="name" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="email" style="color: white">Email:</label><br /><br />
    <input id="email" class="input" name="email" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="address" style="color: white">Address:</label><br /><br />
    <textarea id="address" class="input" name="address" rows="7" cols="30"></textarea><br />
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
     <input id="phone" class="input" name="phone" type="text" value="" size="30" /><br />
</div>
<div class="row">
   <br />
   <label for="membership_date" style="color: white">Membership Date:</label><br /><br />
   <input id="membership_date" class="input" name="membership_date" type="date" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="renewal_tag" style="color: white">Renewal:<br /><br />
    <input type="radio" name="renewal_tag" value="Yes" checked /> Yes<br />
    <input type="radio" name="renewal_tag" value="No" /> No<br />
    </label>
</div>
<div class="row">
     <br />
     <label for="renewal_date" style="color: white">Renewal Date:</label><br /><br />
     <input id="renewal_date" class="input" name="renewal_date" type="date" value="" size="30" /><br />
</div>
<div class="row">
     <br />
     <label for="place_joining" style="color: white">Place of Joining:</label><br /><br />
     <input id="place_joining" class="input" name="place_joining" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="membership_type" style="color: white">Type of membership:</label><br /><br />
    <input id="membership_type" class="input" name="membership_type" type="text" value="" size="30" /><br />
</div>

<br />
<input id="submit_button" type="submit" value="Add" style="font-size: 60px"/>
</form>

    <a href="login.jsp" class="button">Home</a>

</body>
</html>