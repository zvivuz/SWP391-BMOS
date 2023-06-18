/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Cart.Cart;
import Cart.CartItem;
import Product.DAO;
import Product.DTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author HP
 */
@WebServlet(name = "BuyController", urlPatterns = {"/Buy"})
public class BuyController extends HttpServlet {
   private final DAO productDao = new DAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();

        if (session.getAttribute("giohang") == null) {
            Cart myCart = new Cart();

            CartItem item = new CartItem();

            String pid = request.getParameter("id");
            DTO p = productDao.getProductById(pid);

            item.setProduct(p);
            item.setAmount(1);

            myCart.getListCartItem().add(item);

            session.setAttribute("giohang", myCart);
        } else {
            Cart myCart = (Cart) session.getAttribute("giohang");
            String pid = request.getParameter("id");
            if (myCart.containsKey(pid)) {
                session.setAttribute("giohang", myCart);
            } else {
                CartItem item = new CartItem();

                DTO p = productDao.getProductById(pid);
                item.setProduct(p);
                item.setAmount(1);
                myCart.getListCartItem().add(item);
                session.setAttribute("giohang", myCart);
            }

        }

        response.sendRedirect("ShoppingController");
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
        processRequest(request, response);
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
        processRequest(request, response);
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