<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="SECURITYQUESTION.css">
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
        <div id="SECURITYQUESTIONSECTION">
            <h2 class="INNERHEADINGS">Select your security question and answer it:</h2>
            <form action="SECURITYQUESTION" method="POST">
                <br>
                <select id="SECURITYQUESTION" name="SECURITYQUESTION">
                    <option value="Select">Select a security question for your account :*</option>
                    <option value="Nick Name">What is your nick name ?</option>
                    <option value="Freind Name">What is your favourite freind name ?</option>
                    <option value="Pet Name">What is your favourite pet name ?</option>
                </select>
                <br>
                <br>
                <input id="SECURITYANSWER" type="text" name="SECURITYANSWER">
                <br>
                <br>
                <button class="PROCEED" type="submit">Proceed</button>
            </form>
        </div>
    </body>
</html>
