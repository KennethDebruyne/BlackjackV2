/*
    BEHEER SERVLET
    Servlet used for all the administrator options on the site.
 */

package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databank.model.*;
import databank.service.BlackjackService;

public class BeheerServlet extends HttpServlet {

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

        RequestDispatcher view;
        switch (buttonValue.toUpperCase()) {
            case "LOG":
                UserRecord logUser = getUserRecord(request);
                request.setAttribute("user", logUser);
                
                int userId = logUser.getUserId();
                List<LogRecord> logUserArr = BlackjackService.getDataLogUser(userId);
                request.setAttribute("logUserArr", logUserArr);
                
                view = request.getRequestDispatcher("GebruikersbeheerLog.jsp");
                view.forward(request, response);

                break;
            
            case "EDIT":
                UserRecord editUser = getUserRecord(request);
                request.setAttribute("user", editUser);
                
                view = request.getRequestDispatcher("GebruikersbeheerEdit.jsp");
                view.forward(request, response);
                
                break;
            
            case "DELETE":
                UserRecord deleteUser = getUserRecord(request);
                request.setAttribute("user", deleteUser);
                
                view = request.getRequestDispatcher("GebruikersbeheerDelete.jsp");
                view.forward(request, response);             

                break;
            
            case "NEW":
                view = request.getRequestDispatcher("GebruikersbeheerNew.jsp");
                view.forward(request, response);
                
                break;
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

    //Gets and sets
    //Returns a user object by id.
    private final UserRecord getUserRecord(HttpServletRequest request) {
        int userId = -1;
        userId = Integer.valueOf(request.getParameter("hiddenId"));
        
        return BlackjackService.getDataUser(userId);
        
    }
    
}
