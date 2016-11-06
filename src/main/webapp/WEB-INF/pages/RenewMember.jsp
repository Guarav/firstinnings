<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />


<p class="search"> Search by</p>

<form data-ng-controller="renew-member-controller" class="form_member" id="contact_form" method="POST" action="/renewMember">

    <div class="row">
        <br /><label for="name" style="color: white">Phone:</label><br />
        <input data-ng-model="phone" data-ng-blur="findMember('phone',  phone)" class="input" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br /><label for="membership_id" style="color: white">Membership ID:</label><br />
        <input data-ng-model="id" data-ng-blur="findMember('id', id)" class="input" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
       <br /> <label for="renewal_date" style="color: white">Email Id:</label><br />
        <input data-ng-model="email" data-ng-blur="findMember('email', email)" class="input" value="" size="30" /><br />
    </div>
    <br />


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


</form>


<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />