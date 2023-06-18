/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Cart.Cart;
import Cart.CartItem;
import Product.DAO;
import Product.DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HP
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/thanhtoan"})
public class PaymentController extends HttpServlet {

    private final DAO productDao = new DAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
         Cart myCart = new Cart();
        HttpSession session = request.getSession();
        DTO p = null;
        try {
            if (session.getAttribute("giohang") != null) {
                myCart = (Cart) session.getAttribute("giohang");
                for (CartItem ob : myCart.getListCartItem()) {
                    p = new DTO();
                    p = productDao.getProductById(ob.getProduct().getProduct_id());
                    if (p.getQuantity() >= ob.getAmount()) {
                        int quant = p.getQuantity() - ob.getAmount();
                        if (quant == 0) {
                            productDao.deleteProduct(p.getProduct_id());
                        } else {
                            p.setQuantity(quant);
                           productDao.update(p);
                        }
                        request.setAttribute("payment", "success");
                    } else {
                        session.removeAttribute("giohang");
                        request.setAttribute("payment", "fail");
                    }
                }
                session.removeAttribute("giohang");
                    RequestDispatcher rd = getServletContext().
                            getRequestDispatcher("/viewcart.jsp");
                    rd.forward(request, response);
            }
        } catch (Exception e) {
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
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
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
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
