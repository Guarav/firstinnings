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
        top: 130px;
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


    <form id="contact_form" action="#" method="POST" enctype="multipart/form-data">
<div class="row">
    <br />
    <label for="name" style="color: white">Your name:</label><br /><br />
    <input id="name" class="input" name="name" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="email" style="color: white">Your email:</label><br /><br />
    <input id="email" class="input" name="email" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="message" style="color: white">Your message:</label><br /><br />
    <textarea id="message" class="input" name="message" rows="7" cols="30"></textarea><br />
</div>
<br />
<input id="submit_button" type="submit" value="Send email" />
</form>

    <a href="index.html" class="button">Home</a>

</body>
</html>