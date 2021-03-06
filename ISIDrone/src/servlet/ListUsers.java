/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import action.ActionAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Const;

/**
 *
 * @author rcorroch
 */
@WebServlet(name = "ListUsers", urlPatterns = {"/ListUsers"})
public class ListUsers extends HttpServlet {

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
        String afficherUsers = request.getParameter("afficherTout");
        String userSearch = request.getParameter("search");
        String search = request.getParameter("rechercher");
        String modifierUser = request.getParameter("modifierUser");
        String userId = request.getParameter("userId");
// voir pourquoi dans le deploiment le code ne functione plus
        if (Boolean.valueOf(afficherUsers)) {
            ActionAdmin.getallUsers(request);
            request.getRequestDispatcher(Const.PATH_PAGE_LIST_USERS).forward(request, response);
        } else if (userSearch != "" && userSearch != null) {
            ActionAdmin.getallUsersBySearch(request, userSearch);
            request.getRequestDispatcher(Const.PATH_PAGE_LIST_USERS).forward(request, response);
        } else if (Boolean.valueOf(modifierUser) && userId != null) {
            
            request.getRequestDispatcher(Const.PATH_PAGE_MODIFIER_USER).forward(request, response);
        } else {
            ActionAdmin.getallUsers(request);
            request.getRequestDispatcher(Const.PATH_PAGE_LIST_USERS).forward(request, response);

        }

        /* TODO output your page here. You may use following sample code. */
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
