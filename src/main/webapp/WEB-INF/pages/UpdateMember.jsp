<!DOCTYPE html>
<html>
<style>
    body {
        background-image: url("https://s16.postimg.org/6ufcbft5h/Running1.jpg") ;
        background-repeat: no-repeat;
        background-size: cover;
        background-attachment: fixed;
    }

    .search {
        color: white;
        font-size: 20px;
        position: absolute;
        top: 10px;
        left: 500px;

    }

    .search {
        color: white;
        font-size: 20px;
        position: absolute;
        top: 10px;
        left: 500px;

    }

    .or {
        color: white;
        font-size: 20px;
        position: absolute;
        top: 100px;
        left: 0px;

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

</body>
</html>