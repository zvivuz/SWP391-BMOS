<%-- 
    Document   : signup-page
    Created on : Jul 4, 2023, 4:12:35 PM
    Author     : Giang Hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" href="sign-in-up/sign-up-style.css">
    </head>
    <body>
        <div class="container">
            <div class="overlay" id="overlay">
                <div class="sign-in" id="sign-in">
                    <h1>Welcome!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button type="submit" class="switch-button" id="slide-right-button"><a style="text-decoration: none; color: white" href="login-page.jsp">Sign In</a></button>
                </div>
            </div>
            <div class="form">
                <div class="sign-up" id="sign-up-info">
                    <h1>Create Account</h1>
                    <style>
                        /* Basic form styles */
                        .container{
                            width: var(--form-width);
                            height: var(--form-height);
                            position: relative;
                            margin: auto;
                            box-shadow: 2px 10px 40px rgba(22,20,19,0.4);
                            border-radius: 10px;
                            margin-top: 50px;
                        }

                        :root{
                            --form-height:650px;
                            --form-width: 900px;
                            /*  Sea Green */
                            --left-color: #9fdeaf;
                            /*  Light Blue  */
                            --right-color: #96dbe2;
                        }

                        form {
                            max-width: 400px;
                            margin: 0 auto;
                        }

                        input {
                            width: 100%;
                            padding: 10px;
                            margin-bottom: 15px;
                            border: 1px solid #ccc;
                            border-radius: 5px;
                        }

                        .error-message {
                            color: red;
                            font-size: 14px;
                            margin-bottom: 10px;
                        }

                        button {
                            background-color: #4CAF50;
                            color: white;
                            padding: 10px 15px;
                            border: none;
                            border-radius: 5px;
                            cursor: pointer;
                        }

                        button:hover {
                            background-color: #45a049;
                        }
                    </style>

                    <!-- Your HTML code with the form -->
                    <form id="sign-up-form" action="CreateUserController" method="POST">
                        <input type="text" id="username" name="username" placeholder="Username" required=""/>
                        <div class="error-message">${requestScope.USER_ERROR.userNameError}</div>

                        <input type="password" id="password" name="password" placeholder="Password" required="">
                        <div class="error-message">${requestScope.USER_ERROR.passwordError}</div>

                        <input type="password" id="confirmpw" name="confirmpw" placeholder="Confirm Password" required="">
                        <div class="error-message">${requestScope.USER_ERROR.confirmPsError}</div>

                        <input type="text" id="email" name="email" placeholder="Email" required="">
                        <div class="error-message">${requestScope.USER_ERROR.emailError}</div>

                        <!-- Add similar divs for other inputs and error messages -->

                        <button class="control-button up" type="submit" name="action" value="Create Account">Sign Up</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
