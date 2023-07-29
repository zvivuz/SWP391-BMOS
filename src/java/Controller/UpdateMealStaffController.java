/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

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
import javax.crypto.AEADBadTagException;
import meal.Meal;
import meal.MealDAO;


@WebServlet(name = "UpdateMealStaffController", urlPatterns = {"/UpdateMealStaffController"})
public class UpdateMealStaffController extends HttpServlet {

    private final String View = "product-admin-page.jsp";

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

        String meal_id = request.getParameter("sid");
        MealDAO dao = new MealDAO();
        Meal s = dao.getMealById(meal_id);

        
        request.setAttribute("mid", s);

        request.getRequestDispatcher("meal-staff-page.jsp").forward(request, response);

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
        MealDAO dao = new MealDAO();
        String p_quantity = request.getParameter("quantity");
        String meal_package_id = request.getParameter("meal_package_id"); 
        String p_product_id = request.getParameter("product_id");           
        
        dao.updateMeal(p_quantity, meal_package_id, p_product_id);
        HttpSession session = request.getSession();
        List<Meal> list = dao.ViewMeal();
        session.setAttribute("Package", list);
        response.sendRedirect("meal-staff-page.jsp");
//      url = View;

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