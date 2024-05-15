<%@page import="back.Newuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="SIGNUP2.css">
        <!--link rel="stylesheet" href="COMMONSECTION.css"-->
    </head>
    <body>
        <%!
                    Newuser NU=new Newuser();
           %>
        <div id="LOGO">
            <h1>PARATHA <br>&ensp;HOUSE</h1>
        </div>
        <div id="LINKS">
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contac Us</a></li>
                <li><a href="#">Admin</a></li>
            </ul>
        </div>
        
        <div id="SIGNUPSECTION">
            <h2 class="INNERHEADINGS">Note your username and create password</h2>
            <form action="SIGNUP2" method="POST">
            <table>
                
                
                <tr><td>Username*</td><td>&emsp;<%
                                                                                                out.print("<input disabled id='USERNAME' type='text' name='USERNAME' value='"+NU.username+"'>");
                                                                                            %></td></tr>
                <tr><td>Password*</td><td>&emsp;<input type="password" name="PASSWORD"></td></tr>
                <tr><td>Confirm Password*</td><td>&emsp;<input type="password" name="CONFIRMPASSWORD"></td></tr>
            </table>
                <br>
                <button class="SIGNUP" type="submit">Submit</button>
                <br>
                <br>
                <button class="RESET" type="reset">Reset</button>
            </form>
        </div>
       
    </body>
</html>
