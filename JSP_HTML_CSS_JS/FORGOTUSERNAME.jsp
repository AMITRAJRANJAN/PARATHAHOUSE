<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="FORGOTUSERNAME.css">
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
        <div id="USERDETAILSECTION">
            <h2 class="INNERHEADINGS">Enter the required details</h2>
            <form action="FORGOTUSERNAME" method="post">
                <br>
            <table>
                <tr><td>Mobile*</td><td>&emsp;<input id="MOBILE" type="text" name="MOBILE"></td></tr>
                <tr><td>Email*</td><td>&emsp;<input id="EMAIL" type="text" name="EMAIL"></td></tr>
            </table>
                <br>
                <br>
                <button class="PROCEED" type="submit">Proceed</button>
            </form>
        </div>
    </body>
</html>
