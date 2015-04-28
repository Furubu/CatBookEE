/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.UsercbFacade;
import entity.Usercb;

/**
 *
 * @author Furu
 */
@WebServlet(name = "FriendUnblockServlet", urlPatterns = {"/FriendUnblock"})
public class FriendUnblockServlet extends HttpServlet {
    @EJB
    private UsercbFacade userFacade;

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

        //HttpSession session = request.getSession();
        //Usercb user = (Usercb) session.getAttribute("user");
        Integer userId = 1;
        Usercb user = this.userFacade.find(userId);
        
        Integer friendId = 0;
        try {
            String str = request.getParameter("friendId");
            if (str != null) {
                friendId = Integer.parseInt(request.getParameter("friendId"));
            }
        } catch (NumberFormatException e) {
            RequestDispatcher rd;
            rd = (RequestDispatcher) this.getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
            return;
        }
        
        Usercb friend = this.userFacade.find(friendId);
        
        Collection listaBloqueados;
        listaBloqueados = user.getBlockingCollection();
        listaBloqueados.remove(friend);
        
        Collection listaBloqueadoPor;   
        listaBloqueadoPor = friend.getBlockedByCollection();
        listaBloqueadoPor.remove(user);
       
        this.userFacade.edit(user);
        this.userFacade.edit(friend);
        
        response.sendRedirect("FriendList");    
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
