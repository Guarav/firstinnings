<%--
  Created by IntelliJ IDEA.
  User: poplig
  Date: 11/23/16
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="row">
    <br />
    <label for="name" class="label_form" >Name:</label>
    <input id="name" required class="input" name="name" type="text" data-ng-model="member.name" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="email" class="label_form">Email:</label>
    <input id="email" required class="input" name="email" type="text" data-ng-model="member.email" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="address" class="label_form">Address:</label>
    <textarea id="address" required class="input" name="address" data-ng-model="member.address" rows="7" cols="30"></textarea><br />
</div>
<div class="row">
    <br />
    <label for="sex" class = "label_form">Sex:</label>
    <select data-ng-model="member.sex" id="sex" name="sex">
        <option value="male">Male</option>
        <option value="female">Female</option>
    </select>
</div>
<div class="row">
    <br />
    <label for="phone" class="label_form">Phone Number:</label>
    <input id="phone" data-ng-model="member.phone" required class="input" name="phone" type="text" value="" size="30" /><br />
</div>
<div class="row">
    <br />
    <label for="birth_date" class="label_form">Date of birth:</label>
    <input id="birth_date" data-ng-model="member.birthDate" required class="input datepicker" name="birth_date" type="text" placeholder="dd-mm-yyyy" size="30" /><br />
</div>
<div class="row">
    <br />
    <label class="label_form" for = "marital_status">Marital Status</label>
    <select data-ng-model="member.maritalStatus" id="marital_status" name="marital_status">
        <option value="">Married</option>
        <option value="">Single</option>
    </select>
</div>
<div class="row">
    <br />
    <label for="membership_date" class="label_form">Membership Date:</label>
    <input id="membership_date" data-ng-model="member.membershipDate" required class="input datepicker" name="membership_date" type="text" placeholder="dd-mm-yyyy" size="30" /><br />
</div>