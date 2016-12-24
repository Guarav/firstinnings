<%--
  Created by IntelliJ IDEA.
  User: poplig
  Date: 9/18/16
  Time: 3:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>


<head>
    <meta charset="utf-8"/>
    <link rel="icon" href="/static/images/favicon.ico">
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
                changeYear: true,
                dateFormat: "dd-mm-yy",
                yearRange: "1950:2030"
            });
        } );
    </script>

</head>

<body ng-app="firstinnings">

<jsp:include page="elements/message.jsp"/>


