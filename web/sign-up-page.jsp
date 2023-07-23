<%-- 
    Document   : signup-page
    Created on : Jul 4, 2023, 4:12:35 PM
    Author     : Giang Hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="social-media-buttons">
                        <div class="icon">
                            <svg viewBox="0 0 24 24">
                            <path fill="#000000" d="M17,2V2H17V6H15C14.31,6 14,6.81 14,7.5V10H14L17,10V14H14V22H10V14H7V10H10V6A4,4 0 0,1 14,2H17Z" />
                            </svg>
                        </div>
                        <div class="icon">
                            <svg viewBox="0 0 24 24">
                            <path fill="#000000" d="M23,11H21V9H19V11H17V13H19V15H21V13H23M8,11V13.4H12C11.8,14.4 10.8,16.4 8,16.4C5.6,16.4 3.7,14.4 3.7,12C3.7,9.6 5.6,7.6 8,7.6C9.4,7.6 10.3,8.2 10.8,8.7L12.7,6.9C11.5,5.7 9.9,5 8,5C4.1,5 1,8.1 1,12C1,15.9 4.1,19 8,19C12,19 14.7,16.2 14.7,12.2C14.7,11.7 14.7,11.4 14.6,11H8Z" />
                            </svg>
                        </div>
                        <div class="icon">
                            <svg viewBox="0 0 24 24">
                            <path fill="#000000" d="M21,21H17V14.25C17,13.19 15.81,12.31 14.75,12.31C13.69,12.31 13,13.19 13,14.25V21H9V9H13V11C13.66,9.93 15.36,9.24 16.5,9.24C19,9.24 21,11.28 21,13.75V21M7,21H3V9H7V21M5,3A2,2 0 0,1 7,5A2,2 0 0,1 5,7A2,2 0 0,1 3,5A2,2 0 0,1 5,3Z" />
                            </svg>
                        </div>
                    </div>
                    <p class="small">or use your email for registration:</p>
                    <form id="sign-up-form" action="DispatchServlet" method="POST">
                        <input type="text" id="username" name="username" placeholder="Username" required="">
                        ${requestScope.userNameError}
                        <input type="password" id="password" name="password" placeholder="Password" required="">
                        ${requestScope.passwordError}
                        <input type="password" id="confirmpw" name="confirmpw" placeholder="Confirm Password" required="">
                        ${requestScope.confirmPsError}
                        <input type="text" id="email" name="email" placeholder="Email" required="">
                        ${requestScope.emailError}
                        <input type="hidden" id="fullName" name="fullName" required="">
                        ${requestScope.fullNameError}
                        <input type="hidden" id="phone" name="phone" required="">
                        ${requestScope.phoneError}
                        <input type="hidden" id="address" name="address" required="">
                        ${requestScope.addressError}
                        <button class="control-button up" type="submit" name="action" value="Create Account">Sign Up</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
