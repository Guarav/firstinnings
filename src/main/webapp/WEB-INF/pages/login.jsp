<jsp:include page="header.jsp" />


    <h1>EForce</h1>
    <h2 style="color: white;">We are here for you</h2>


    <form action="/login" method="post">
        <p>Username:<br></p>
        <input class="Input" type="text" name="username" />
        <br>
        <p>Password:<br></p>
        <input class="Input" type="password" name="password" />
        <br><br><br>
        <input class="Submit" type="submit" value="Login" />
    </form>

    <a href="Writetous.jsp" class="button">Write to Us</a>


<jsp:include page="footer.jsp" />