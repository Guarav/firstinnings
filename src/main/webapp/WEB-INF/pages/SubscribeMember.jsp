<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<br>
<%--<p class="search"> Search by</p>--%>

<form data-ng-controller="subscription-member-controller" class="form_member" id="contact_form" method="POST" action="/subscribeMember">

    <select ng-model="medium">
        <option disabled value="">Search By:</option>
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
            <div>
                {{member.name}}, {{member.email}} {{member.address}}
            </div>

        <input id="membership_id" name="memberId" type="hidden"/>
        <div class="row">
            <br />
            <label for="subscription_date" class="label_form">Subscription date:</label>
            <input id="subscription_date" required class="input datepicker" name="subscription_date" placeholder="dd-mm-yyyy" value="" size="30" /><br />
        </div>

        <div class="row">
            <br />
            <label for="membership_months" class="label_form">Months of membership:</label>

            <select id="membership_months" name="membership_months">
                <option disabled value="">Select:</option>
                <option value="1">1 month</option>
                <option value="2">2 months</option>
                <option value="3">3 months</option>
                <option value="6">6 months</option>
                <option value="12">1 year</option>
            </select>


        </div>
        <div class="row">
            <br />
            <label for="amount_paid" class="label_form">Amount paid:</label>
            <input id="amount_paid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
        </div>
        <div class="row">
            <br />
            <label for="place" class="label_form">Place:</label>

            <select id="place" name="place">
                <option disabled value="">Select:</option>
                <option value="New Delhi">New Delhi</option>
                <option value="Noida">Noida</option>
                <option value="Gurgaon">Gurgaon</option>

            </select>
        </div>

        <input id="submit_button" type="submit" value="Add Subscription" style="font-size: 100%"/>

    </div>

    <div data-ng-show="!members">
        <span ng-model="errorMessage"></span>
    </div>


</form>


<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />