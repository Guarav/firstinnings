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


    h1 {
        color: white;
        font-size: 60px;
    }

    p {
        color: white;
        font-size: 20px;
    }
    
    form {

        position: relative;
        top: 55px;
        left: 500px;
    }

    .Input {
        width: 200px;
    }

    .Submit {
        width: 8em;
        height: 20em;
        font-size: 20px;
    }

    .button {
        position: absolute;
        top: 10px;
        left: 800px;
        padding:10px;
        background-color: antiquewhite;
        color:black;
        text-decoration:none;
        border-radius: 10px;
    }

</style>

<body>

    <h1>EForce</h1>
    <h2 style="color: white;">We are here for you</h2>


    <form action="/firstinnings/login" method="post">
        <p>Username:<br></p>
        <input class="Input" type="text" name="username" />
        <br>
        <p>Password:<br></p>
        <input class="Input" type="password" name="password" />
        <br><br><br>
        <input class="Submit" type="submit" value="Login" />
    </form>

    <a href="Writetous.jsp" class="button">Write to Us</a>


</body>
</html>