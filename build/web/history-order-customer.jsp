<%-- 
    Document   : history_order_customer
    Created on : Jul 12, 2023, 4:16:31 PM
    Author     : 09047
--%>

<%@page import="User.UserDTO"%>
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
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> bmos@gmail.com</li>
                                    <li>Free Shipping for all Order of 2 million</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>
                                <div class="header__top__right__language">
                                    <c:if test="${sessionScope.LOGIN_USER != null}">
                                        <a style="color: #1c1c1c"><i class="fa fa-user"></i>Hello, ${sessionScope.LOGIN_USER.fullname}</a>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="userProfile.jsp">View profile</a></li>
                                            <li><a href="history-order-customer.jsp">History order</a></li>
                                            <li><a href="LogoutController">Log out</a></li>
                                        </ul>
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
                                <li class="active"><a href="ViewController">Home</a></li>
                                <li><a href="ViewShopPageController">Shop</a></li>
                                <li><a href="ViewMealPackageController">Meal</a></li>
                                <li><a href="ViewBlogController">Blog</a></li>
                                <li><a href="./contact.jsp">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
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
                                        <a href="#" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/ba61750a46794d8847c3f463c5e71cc4"
                                                />
                                            <p>My Account</p>
                                        </a>
                                        <a href="#" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/f0049e9df4e536bc3e7f140d071e9078"
                                                />
                                            <p>My Purchase</p>
                                        </a>
                                        <a href="#" class="sub-menu-link">
                                            <img
                                                src="https://down-vn.img.susercontent.com/file/e10a43b53ec8605f4829da5618e0717c"
                                                />
                                            <p>Notifications</p>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                <table>
                                    <thead>
                                        <tr>
                                            <th><p>ID</p></th>
                                            <th><p>Code Order</p></th>
                                            <th><p>Total</p></th>
                                            <th><p>Date Order</p></th>
                                            <th><p>Status</p></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Nguyễn Văn A</td>
                                            <td>Áo thun</td>
                                            <td>2023-07-01</td>
                                            <td><span class="status status-pending">Đang chờ</span></td>
                                            <td>
                                                <button onclick="showDetails(1)">Xem chi tiết</button>
                                                <div class="details" id="details-1">
                                                    <p>Chi tiết đơn hàng 1...</p>
                                                    <!--                                                    <p>
                                                                                                            Trạng thái:
                                                                                                            <span class="status status-pending">Đang chờ</span>
                                                                                                        </p>-->
                                                </div>
                                            </td>
                                        </tr>
<!--                                        <tr>
                                            <td>2</td>
                                            <td>Trần Thị B</td>
                                            <td>Quần jeans</td>
                                            <td>2023-07-05</td>
                                            <td><span class="status status-shipped">Đã giao hàng</span></td>
                                            <td>
                                                <button onclick="showDetails(2)">Xem chi tiết</button>
                                                <div class="details" id="details-2">
                                                    <p>Chi tiết đơn hàng 2...</p>
                                                    <p>
                                                        Trạng thái:
                                                        <span class="status status-shipped">Đã giao hàng</span>
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Phạm Văn C</td>
                                            <td>Ghế văn phòng</td>
                                            <td>2023-07-10</td>
                                            <td><span class="status status-delivered">Đã nhận hàng</span></td>
                                            <td>
                                                <button onclick="showDetails(3)">Xem chi tiết</button>
                                                <div class="details" id="details-3">
                                                    <p>Chi tiết đơn hàng 3...</p>
                                                    <p>
                                                        Trạng thái:
                                                        <span class="status status-delivered">Đã nhận hàng</span>
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>-->
                                    </tbody>
                                </table>
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
                                <div>Phone: +65 11.188.888</div>
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
                            <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
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