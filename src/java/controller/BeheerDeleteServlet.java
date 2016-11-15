/*
    BEHEER DELETE SERVLET
    Servlet used for deleting an existing user from the database.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databank.service.BlackjackService;

public class BeheerDeleteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String buttonValue = request.getParameter("btnOption");
        
        RequestDispatcher view = request.getRequestDispatcher("Gebruikersbeheer.jsp");
        switch(buttonValue.toUpperCase()) {
            case "VERWIJDEREN":
                int userId = Integer.parseInt(request.getParameter("txtUserId"));
                BlackjackService.deleteDataUser(userId);
                
                view.forward(request, response);
                break;
                
            case "TERUG":
                view.forward(request, response);
                break;
            
        } 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

}
