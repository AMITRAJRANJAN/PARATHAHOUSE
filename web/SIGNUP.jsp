<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="SIGNUP.css">
         <!--link rel="stylesheet" href="COMMONSECTION.css"-->
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
            <h2 class="INNERHEADINGS">Signup to Paratha House</h2>
            <form action="SIGNUP" method="POST">
            <table>
                <tr><td>Name*</td><td>&emsp;<input id="NAME" type="text" name="NAME"></td></tr>
                <tr><td>Mobile*</td><td>&emsp;<input id="MOBILE" type="text" name="MOBILE"></td></tr>
                <tr><td>Email*</td><td>&emsp;<input id="EMAIL" type="text" name="EMAIL"></td></tr>    
            </table>
                <br>
                <button class="SIGNUP" type="submit">Generate Username</button>
                <br>
                <br>
                <button class="RESET" type="reset">Reset</button>
            </form>
        </div>
        
        <script src="USERNAME.js"></script>
            
    </body>
</html>
