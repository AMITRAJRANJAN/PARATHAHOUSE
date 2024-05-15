<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ADMINLOGIN.css">
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
                <li><a href="#">Admin</a></li>
            </ul>
        </div>
        
        <div id="SIGNUPSECTION">
            <h2 class="INNERHEADINGS">Login as Admin</h2>
            <form action="ADMINLOGIN" method="POST">
            <table>
                <tr><td>Username*</td><td>&emsp;<input id="NAME" type="text" name="USERNAME"></td></tr>
                <tr><td>Password*</td><td>&emsp;<input id="MOBILE" type="text" name="PASSWORD"></td></tr>
            </table>
                <br>
                <button class="LOGIN" type="submit">Login</button>
                <br>
                <br>
                <button class="RESET" type="reset">Reset</button>
            </form>
        </div>
    </body>
</html>
