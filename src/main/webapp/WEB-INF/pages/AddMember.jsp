<jsp:include page="header.jsp" />

<form id="contact_form" class="form_member" method="post" action="/addAMember">

    <jsp:include page="memberDetails.jsp" />

    <div class="row">
        <br />
        <label for="place" class="label_form">Place of Joining:</label>
        <input id="place" data-ng-model="member.placeJoining" required class="input" name="place" type="text" value="" size="30" /><br />
    </div>
    <div class="row">
        <br />
        <label for="membership_months" class="label_form">Months of membership:</label>
        <select data-ng-model="member.membershipMonths" id="membership_months" name="membership_months">
            <option disabled value="">Select:</option>
            <option value="">1 month</option>
            <option value="">2 months</option>
            <option value="">3 months</option>
            <option value="">6 months</option>
            <option value="">1 year</option>
            <option value="">Other</option>
        </select>

        <%--<input id="membership_months" data-ng-model="member.membershipMonths" required class="input" name="membership_months" type="text" value="" size="30" /><br />--%>
    </div>

    <div class="row">
        <br />
        <label for="sex" class = "label_form">Sex:</label>
        <select data-ng-model="member.sex" id="sex" name="sex">
            <option disabled value="">Select:</option>
            <option value="">Male</option>
            <option value="">Female</option>
        </select>
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