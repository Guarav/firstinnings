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
    <title></title>
    <link type="text/css" rel="stylesheet" href="/static/css/common.css" />
    <link type="text/css" rel="stylesheet" href="/static/css/thirdparty.css" />
</head>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="/static/css/jquery-ui.css" />
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/jquery-ui.js"></script>
    <script>
        $(function() {
            $( ".datepicker" ).datepicker();
            $( "#format" ).change(function() {
                $( ".datepicker" ).datepicker( "option", "dateFormat", $( this ).val() );
            });
        });
        
    </script>

</head>

<body>

    <jsp:include page="message.jsp" />


