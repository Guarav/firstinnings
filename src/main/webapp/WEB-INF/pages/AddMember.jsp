<jsp:include page="header.jsp" />

<form id="contact_form" class="form_member" method="post" action="/addAMember">

    <jsp:include page="memberDetails.jsp" />

    <div class="row">
        <br />
        <label for="place" class="label_form">Place of Joining:</label>
        <select data-ng-model="member.placeJoining" id="place" name="place">
            <option disabled value="">Select:</option>
            <option value="New Delhi">New Delhi</option>
            <option value="Noida">Noida</option>
            <option value="Gurgaon">Gurgaon</option>

        </select>

    </div>
    <div class="row">
        <br />
        <label for="membership_months" class="label_form">Months of membership:</label>
        <select data-ng-model="member.membershipMonths" id="membership_months" name="membership_months">
            <option disabled value="">Select:</option>
            <option value="1">1 month</option>
            <option value="2">2 months</option>
            <option value="3">3 months</option>
            <option value="6">6 months</option>
            <option value="12">1 year</option>
        </select>

        <%--<input id="membership_months" data-ng-model="member.membershipMonths" required class="input" name="membership_months" type="text" value="" size="30" /><br />--%>
    </div>


    <div class="row">
        <br />
        <label for="amount_paid" class="label_form">Amount paid:</label>
        <input id="amount_paid" data-ng-model="member.amountPaid" required class="input" name="amount_paid" type="text" value="" size="30" /><br />
    </div>

    <br />
    <input id="submit_button" type="submit" value="Add" style="font-size: 100%"/>
</form>

<a href="/home" class="button">Home</a>

<jsp:include page="footer.jsp" />