<%@page import="back.Resettinguser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="RESETPASSWORD.css">
        <!--link rel="stylesheet" href="COMMONSECTION.css"-->
    </head>
    <body>
        <%!
                    Resettinguser RU=new Resettinguser();
           %>
        <div id="LOGO">
            <h1>PARATHA <br>&ensp;HOUSE</h1>
        </div>
        <div id="LINKS">
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Admin</a></li>
            </ul>
        </div>
        
        <div id="RESETPASSWORDSECTION">
            <h2 class="INNERHEADINGS">Note your username and create a new password for your account</h2>
            <form action="RESETPASSWORD" method="POST">
            <table>
                <tr><td>Username*</td><td>&emsp;<%
                                                                                                out.print("<input disabled id='USERNAME' type='text' name='USERNAME' value='"+RU.username+"'>");
                                                                                            %></td></tr>
                <tr><td>Password*</td><td>&emsp;<input type="password" name="PASSWORD"></td></tr>
                <tr><td>Confirm Password*</td><td>&emsp;<input type="password" name="CONFIRMPASSWORD"></td></tr>
            </table>
                <br>
                <button class="SUBMIT" type="submit">Submit</button><button class="RESET" type="reset">Reset</button>
            </form>
        </div>
       
     
    </body>
</html>
