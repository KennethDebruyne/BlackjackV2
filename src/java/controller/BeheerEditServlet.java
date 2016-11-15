/*
    BEHEER EDIT SERVLET
    Servlet used for editing an existing user.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databank.model.*;
import databank.service.BlackjackService;

public class BeheerEditServlet extends HttpServlet {

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
            case "AANPASSEN":
                int userId = Integer.parseInt(request.getParameter("hiddenId"));
                UserRecord editedUser = BlackjackService.getDataUser(userId);
                
                String firstName = request.getParameter("txtFirstName");
                String lastName = request.getParameter("txtLastName");
                String iconUri = request.getParameter("txtIconUri");
                String password = editedUser.getPassword();
                int balance = Integer.parseInt(request.getParameter("txtBalance"));
                
                editedUser = new UserRecord(firstName, lastName, iconUri, password, balance);
                editedUser.setUserId(userId);
                
                BlackjackService.editDataUser(editedUser);
                
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
