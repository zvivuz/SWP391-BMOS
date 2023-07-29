<%-- 
    Document   : login-page
    Created on : Jun 19, 2023, 5:06:27 PM
    Author     : 09047
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="sign-in-up/sign-in-style.css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="overlay" id="overlay">
                <div class="sign-up" id="sign-up">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start a journey with us</p>
                    <button type="submit" class="switch-button" id="slide-left-button"><a style="text-decoration: none; color: white" href="sign-up-page.jsp">Sign Up</a></button>
                </div>
            </div>
            <div class="form">
                <div class="sign-up" id="sign-up-info">
                    <h1>Sign In</h1>
                    <form action="LoginController" id="sign-in-form" method="POST">      
                        <input type="text" name="userID" placeholder="Username"/>
                        <input type="password" name="password" placeholder="Password"/>
                        <button class="control-button in" type="submit" name="action" value="Log In">Sign In</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
