<%--
  Created by IntelliJ IDEA.
  User: poplig
  Date: 9/18/16
  Time: 3:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<title>jQuery UI Datepicker - Display month &amp; year menus</title>--%>
    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <%--<link rel="stylesheet" href="/resources/demos/style.css">--%>
    <%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%--<script>--%>
        <%--$( function() {--%>
            <%--$( "#datepicker" ).datepicker({--%>
                <%--changeMonth: true,--%>
                <%--changeYear: true--%>
            <%--});--%>
        <%--} );--%>
    <%--</script>--%>
<%--</head>--%>


<head>
    <meta charset="utf-8"/>
    <link type="text/css" rel="stylesheet" href="/static/css/common.css"/>
    <link type="text/css" rel="stylesheet" href="/static/css/thirdparty.css"/>
    <link rel="stylesheet" href="/static/css/jquery-ui.css"/>
    <script src="/static/js/thirdparty/angular.js"> </script>
    <script src="/static/js/thirdparty/jquery.js"></script>
    <script src="/static/js/thirdparty/jquery-ui.js"></script>
    <script src="/static/js/utils.js"></script>
    <script src="/static/js/app.js"></script>
    <script src="/static/js/httpService.js"></script>
    <script src="/static/js/controllers.js"></script>
    <script>
        $( function() {
            $( ".datepicker" ).datepicker({
                changeMonth: true,
                changeYear: true
            });
        } );
    </script>


    <%--<script>--%>
        <%--$(function () {--%>
            <%--$(".datepicker").datepicker();--%>
            <%--$("#format").change(function () {--%>
                <%--$(".datepicker").datepicker();--%>
<%--//                $(".datepicker").datepicker("option", "dateFormat", $(this).val());--%>
            <%--});--%>
        <%--});--%>

    <%--</script>--%>

</head>

<body ng-app="firstinnings">

<jsp:include page="message.jsp"/>


