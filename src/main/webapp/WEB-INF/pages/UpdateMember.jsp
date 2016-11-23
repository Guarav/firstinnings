<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<br>
<p class="search"> Search by</p>

<form data-ng-controller="update-member-controller" class="form_member" method="POST" action="/updateMember">

    <select ng-model="medium">
        <option value="">Search By:</option>
        <option value="phone">Phone</option>
        <option value="emailId">Email</option>
        <option value="membershipId">Membership Id</option>
    </select>

    <div class="row">
        <br /><label for="name" style="color: white"></label><br />
        <input data-ng-model="value" data-ng-blur="findMember()" class="input" type="text" value="" size="30" /><br />
    </div>

    <br>

    <div style="color:white;" data-ng-show="member" >

        <jsp:include page="memberDetails.jsp" />
        <input id="membership_id" name="memberId" type="hidden"/>

        <input id="submit_button" type="submit" value="Renew" style="font-size: 100%"/>

    </div>

    <div data-ng-show="!members">
        <span ng-model="errorMessage"></span>
    </div>


</form>


<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />