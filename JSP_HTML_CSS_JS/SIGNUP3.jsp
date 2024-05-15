<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="SIGNUP3.css">
        <link rel="stylesheet" href="COMMONSECTION.css">
    </head>
    <body>
        <div id="LOGO">
            <h1>PARATHA <br>&ensp;HOUSE</h1>
        </div>
        <div id="LINKS">
            <ul>
                
            </ul>
        </div>
        
        <div id="SIGNUPSECTION">
            <h2 class="INNERHEADINGS">Select a security question for your account and answer it</h2>
            <form action="SIGNUP3" method="POST">
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
                <button class="SUBMIT" type="submit">Submit</button>
                <br>
                <br>
                <button class="RESET" type="reset">Reset</button>
            </form>
          
        </div>
    </body>
</html>
