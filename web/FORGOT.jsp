<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="FORGOT.css">
        <!--link rel="stylesheet" href="COMMONSECTION.css"-->
    </head>
    <body>
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
        
        <div id="FORGOTSECTION">
            <h2 class="INNERHEADINGS">Select an option then proceed</h2>
            <form action="FORGOT">
                <br>
            <table>
                <tr><td><input id="FORGOT" type="radio" name="FORGOT" value="FORGOT USERNAME">Forgot Username</td></tr>
                <tr><td><input id="FORGOT" type="radio" name="FORGOT" value="FORGOT PASSWORD">Forgot Password</td></tr>
            </table>
                <br>
                <br>
                <button class="PROCEED" type="submit">Proceed</button>
                
            </form>
        </div>
    </body>
</html>
