/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cart.Cart;
import Cart.CartItem;
import Product.DAO;
import Product.DTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import meal.Meal;
import meal.MealPackageDAO;
import meal.MealPackageDTO;

/**
 *
 * @author ptd
 */
@WebServlet(name = "AddMealPackageToCartController", urlPatterns = {"/AddMealPackageToCartController"})
public class AddMealPackageToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        String tnum = request.getParameter("num");
        String tid = request.getParameter("package_id");
        System.out.println("nummmmmmmmmmmmmmm: " + tnum);
        System.out.println("packageeeeeeeeeeee: " + tid);

        HttpSession session = request.getSession();

        Cart cart = null;
        Object o = session.getAttribute("cart");

        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        int num;
        try {
            num = Integer.parseInt(tnum);
//            id = Integer.parseInt(tid);

            MealPackageDAO dao = new MealPackageDAO();
            MealPackageDTO dto = dao.getMealPackageById(tid);
            double price = dto.getPrice();
            CartItem t = new CartItem(dto, num, price);
            cart.addPackageItem(t);
        } catch (NumberFormatException e) {
            num = 1;
        }
        
        List<CartItem> list = cart.getListCartItem();
        session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("DetailMealPackageController?package_id=" + tid).forward(request, response);
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
