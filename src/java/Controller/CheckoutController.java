/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Cart.Cart;
import Cart.CartItem;
import Order.OrderDAO;
import Product.DAO;
import Product.DTO;
import User.UserDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    private final DAO productDao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        DTO product = null;
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        UserDTO user = null;
        Object u = session.getAttribute("LOGIN_USER");
        boolean check = false;
        if (u != null) {
            user = (UserDTO) u;
            OrderDAO ord = new OrderDAO();
            
            cart.getListCartItem();
            for (int i = 0; i < cart.getListCartItem().size(); i++) {
                CartItem item = cart.getListCartItem().get(i);
                int productId = item.getProduct().getProduct_id();
                int quantityInCart = item.getQuantity();
                product = new DTO();
// Kiểm tra số lượng sản phẩm trong database
                product = productDao.getProductById(productId);
                if (product.getQuantity() >= quantityInCart) 
                       check = productDao.checkout(item.getQuantity(), item.getProduct().getProduct_id());
                
                if (check == true) {
                    ord.addOrder(user, cart);
                    session.removeAttribute("cart");
                    session.setAttribute("size", 0);
                    request.setAttribute("MESSAGE", "CHECKOUT SUCCESS");
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    request.setAttribute("MESSAGE", "CHECKOUT FALSE");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

            }

        } else {
            response.sendRedirect("login-page.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        Cart cart = null;
//        Object o = session.getAttribute("cart");
//
//        if (o != null) {
//            cart = (Cart) o;
//        } else {
//            cart = new Cart();
//        }
//        UserDTO user = null;
//        Object u = session.getAttribute("user");
//        Object dto = session.getAttribute("dto");
//        Object order = session.getAttribute("order");
//        if(u!=null){
//            user = (UserDTO)u;
//            dto = (DTO)dto;
//            OrderDAO ord = new OrderDAO();
//            ord.addOrder(user, cart);
//        }
//                
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
//        HttpSession session = request.getSession(true);
//        Cart cart = null;
//        Object o = session.getAttribute("cart");
//
//        if (o != null) {
//            cart = (Cart) o;
//        } else {
//            cart = new Cart();
//        }
//        UserDTO user = null;
//        Object u = session.getAttribute("LOGIN_USER");
//     
//        if(u!=null){
//            user = (UserDTO)u;
//            OrderDAO ord = new OrderDAO();
//            ord.addOrder(user, cart);
//            session.removeAttribute("cart");
//            session.setAttribute("size", 0);
//            response.sendRedirect("shop.jsp");
//        }else{
//            response.sendRedirect("login.html");
//        }
//                
        } catch (Exception ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
