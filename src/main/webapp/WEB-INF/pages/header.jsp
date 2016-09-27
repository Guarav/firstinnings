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
</head>

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
            $( "#format" ).change(function() {
                $( "#datepicker" ).datepicker( "option", "dateFormat", $( this ).val() );
            });
        });
        
    </script>

</head>

<body>
