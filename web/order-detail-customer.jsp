<%-- 
    Document   : history_order_customer
    Created on : Jul 12, 2023, 4:16:31 PM
    Author     : 09047
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="User.UserDTO"%>
<%@page import="Order.OrderDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Profile</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                 if (loginUser == null || !"3".equals(loginUser.getRole_id())) {
                     response.sendRedirect("login-page.jsp");
                     return;
                 }
        %>

        <style type="text/css">
            body {
                background: #f7f7ff;
                /*margin-top: 20px;*/
                font-family: "Cairo", sans-serif;
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: 0.25rem;
                margin-bottom: 1.5rem;
                box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%),
                    0 2px 6px 0 rgb(206 206 238 / 54%);
            }
            .me-2 {
                margin-right: 0.5rem !important;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }

            th,
            td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #f5f5f5;
            }

            .details {
                display: none;
            }

            .status {
                display: inline-block;
                padding: 4px 8px;
                border-radius: 4px;
                font-weight: bold;
            }

            .status-pending {
                background-color: #ffcc00;
                color: #fff;
            }

            .status-shipped {
                background-color: #33cc33;
                color: #fff;
            }

            .status-delivered {
                background-color: #0066ff;
                color: #fff;
            }
        </style>
    </head>
    <body>

       <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row" style="display: flex; align-content: space-around">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> bmos@gmail.com</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
<!--                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>-->
                                <div class="header__top__right__language">
                                    <c:if test="${sessionScope.LOGIN_USER != null}">
                                        <a style="color: #1c1c1c"><i class="fa fa-user"></i>Hello, ${sessionScope.LOGIN_USER.fullname}</a>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="userProfile.jsp">View profile</a></li>
                                            <li><a href="OrderHistoryCustomerController?userID=${sessionScope.LOGIN_USER.userID}">History order</a></li>
                                            <li><a href="LogoutController">Log out</a></li>
                                        </ul>
                                    </c:if>
                                    <c:if test="${sessionScope.LOGIN_USER == null}">
                                        <a style="color: #1c1c1c"href="LoginController"><i class="fa fa-user"></i> Login</a>
                                        <a style="color: #1c1c1c"href="sign-up-page.jsp"><i class="fa fa-user"></i> Sign up</a>
                                    </c:if>   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="ViewController"><img src="img/Bird-logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li><a href="ViewController">Home</a></li>
                                <li><a href="ViewShopPageController">Products</a></li>
                                <li><a href="ViewMealPackageController">Meal</a></li>
                                <li><a href="ViewBlogController">Blog</a></li>
                                <li><a href="./contact.jsp">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <c:set var="size" value="${sessionScope.size}"/>
                            <ul>
                                <li><a href="shoping-cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${size}</span></a></li>
                            </ul>

                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->


        <div class="container">
            <div class="main-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <div class="sub-menu-wrap" id="subMenu">
                                    <div class="sub-menu">
                                        <div class="user-info">
                                            <%= loginUser.getFullname()%>
                                        </div>
                                        <hr/>
                                        <a href="userProfile.jsp" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/ba61750a46794d8847c3f463c5e71cc4"
                                                />
                                            <p>My Account</p>
                                        </a>
                                        <a href="OrderHistoryCustomerController?userID=${sessionScope.LOGIN_USER.userID}" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/f0049e9df4e536bc3e7f140d071e9078"
                                                />
                                            <p>My Purchase</p>
                                        </a>
<!--                                        <a href="#" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/e10a43b53ec8605f4829da5618e0717c"
                                                />
                                            <p>Notifications</p>
                                        </a>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-lg-8">
                        <div class="card">
                            <div class="card-body"">
                                <div style="display: flex; justify-content: space-between; align-items: flex-end">
                                    <h4>Delivery address</h4>
                                </div>
                                <div class="row align-items-start">
                                    <div class="col-9" style="padding-left:20px">
                                        <p style="margin: 0px">Name: <%= loginUser.getFullname()%></p>
                                        <p style="margin: 0px">Phone: <%= loginUser.getPhone()%></p>
                                        <p style="margin: 0px">Address: <%= loginUser.getAddress()%></p>
                                    </div>
                                   
                                </div>
                            </div>
                            <hr style="height: 1px; width: 100%; margin: 0 0 20px">
                            <c:forEach items="${order_detail}" var="o">
                                <c:set value="${total + o.price}" var="total"></c:set>
                                    <a href="ViewController">
                                        <div class="card-body items" style="display: flex; justify-content: space-between; padding: 0px;">
                                            <div class="col-9" style="display: flex">
                                                <img src="img/food/${o.thumbnail}" style="height: 50px; width: 50px; object-fit: cover">
                                            <div style="display: flex; flex: 1;flex-direction: column;align-items: flex-start">
                                                <h5>${o.title_product}</h5>
                                                <p>x${o.quantity}</p>
                                            </div>                                    
                                        </div>
                                        <div class="col-3" style="text-align: end; color: #212529"><fmt:formatNumber pattern="#,### VND" value="${o.price}"/></div>
                                    </div>
                                </a>
                            </c:forEach>
                            <hr style="height: 1px; width: 100%; margin:0px">
                            <div class="card-body" style="display: flex; align-items: end; justify-content: flex-end">
                                Total: <fmt:formatNumber pattern="#,### VND" value="${total}"/>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card">
                                </div>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript"></script>

        <!-- Footer Section Begin -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__about__logo">
                                <a href="ViewController"><img src="img/Bird-logo.png" alt=""></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div>Address: Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</div>    
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__about__logo text-lg-right">
                                <div>Phone: +84 912 128 057</div>
                                <div>Email: bmos@gmail.com</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> BMOS | Bird Order Meal System <i class="fa fa-heart" aria-hidden="true"></i> by <a href="#" target="_blank">BMOS</a></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="window-display"></div>

        </footer>
        <!-- Footer Section End -->
    </body>

    <script>
        function myFunction() {
            var x = document.getElementById("myInput");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
        function showDetails(orderId) {
            var detailsElement = document.getElementById("details-" + orderId);
            if (detailsElement.style.display === "none") {
                detailsElement.style.display = "block";
            } else {
                detailsElement.style.display = "none";
            }
        }
    </script>
</html>