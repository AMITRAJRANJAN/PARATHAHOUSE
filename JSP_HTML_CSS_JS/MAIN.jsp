<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="MAIN.css">
        <link rel="stylesheet" href="COMMONSECTION.css">
    </head>
    <body>
        <div id="LOGO">
            <h1>PARATHA <br>&ensp;HOUSE</h1>
        </div>
        <div id="LINKS">
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="ADMINLOGIN.jsp">Admin</a></li>
            </ul>
            
            
        </div>
        
        <div id="LOGINSECTION">
            <h2 class="INNERHEADINGS">Login to Paratha House</h2>
            <form action="LOGIN" method="POST">
            <table>
                <tr><td>Username*</td><td>&emsp;<input type="text" name="USERNAME"></td></tr>
                <tr><td>Password*</td><td>&emsp;<input type="password" name="PASSWORD"></td></tr>
                <tr><td></td><td><button>Login</button></td></tr>
            </table>
            </form>
            <a href="SIGNUP.jsp">New User Signup</a>
            <br>
            <a href="FORGOT.jsp">Forgot Username or Password</a>
            <br>
            
        </div>
        
    </body>
</html>
