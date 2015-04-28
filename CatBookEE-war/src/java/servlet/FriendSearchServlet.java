/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
@WebServlet(name = "FriendSearchServlet", urlPatterns = {"/FriendSearch"})
public class FriendSearchServlet extends HttpServlet {
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
        
        String search = request.getParameter("searchText");
        List<Usercb> matches = new ArrayList<Usercb>();
        Collection friends = user.getUserFriendsCollection();
        
        for(Usercb u: this.userFacade.findAll()) {
            String name = u.getName() + " " + u.getSurname();
            Collection blocked = u.getBlockingCollection();
            if (name.toLowerCase().contains(search.toLowerCase()) && (!u.equals(user)) && !(friends.contains(u)) && !(blocked.contains(user))){
                matches.add(u);
            }
        }
           
        request.setAttribute("matchList", matches);
  
        RequestDispatcher rd;

        rd = this.getServletContext().getRequestDispatcher("/friendAdd.jsp");
        rd.forward(request, response);
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