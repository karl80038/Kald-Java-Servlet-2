/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
/**
 *
 * @author karl8
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCartServlet extends HttpServlet {
   ArrayList<data.Item> cart = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String name = request.getParameter("shop-itemfield");
            if (name!= null & name.length() >= 1)
            {
              data.Item item = new data.Item(name);  
              cart.add(item);
              HttpSession session = request.getSession(true);
              session.setAttribute("mycart", cart);
              response.sendRedirect("index.html");

            }
            else
            {
               try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html lang='et'>");
                    out.println("<head>");
                    out.println("<meta charset='Unicode'>");
                    out.println("<title>Servlet CartServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Error</h1>");
                    out.println("You didn't specify the item or the item you specified is not valid.");
                    out.println("<br>");
                    out.println("<a href='index.html'>Back to shopping</a>");
                    out.println("</body>");
                    out.println("</html>");
               }

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
