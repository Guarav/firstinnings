<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<br>
<p class="search"> Search by</p>

<form data-ng-controller="renew-member-controller" class="form_member" id="contact_form" method="POST" action="/renewMember">

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

    <div style="color:white;" data-ng-show="members" >
        <div data-ng-repeat="member in members">
            <span>
                <input data-ng-click="selectMember(member)" type="radio" >
                {{member.name}}, {{member.email}} {{member.address}}
            </span>
        </div>

        <input id="membership_id" name="memberId" type="hidden"/>
        <div class="row">
            <br />
            <label for="renewal_date" class="label">Renewal date:</label>
            <input id="renewal_date" required class="input datepicker" name="renewal_date" value="" size="30" /><br />
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

        <input id="submit_button" type="submit" value="Renew" style="font-size: 100%"/>

    </div>

    <div data-ng-show="!members">
        <span ng-model="errorMessage"></span>
    </div>


</form>


<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />