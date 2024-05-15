<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ADMINPANEL.css">
    </head>
    <body>
        <%@include file="ADMINHEADER.jsp" %>
        <%
            String adminname=session.getAttribute("ADMINNAME").toString();
            out.print("<h3 id='CURRENTUSER'>Hello Mr. "+adminname+"&emsp;<a href='LOGOUT'>Logout</a></h3>");
        %>
        
    </body>
</html>
