/*
    BEHEER LOG SERVLET
    Servlet used for getting extra details about certain logs.
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

public class BeheerLogServlet extends HttpServlet {

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
        switch(buttonValue.toUpperCase()) {
            case "DETAILS":
                //User en zijn logs opnieuw opvragen want JSP zendt de vorige request niet door.
                int userId = Integer.parseInt(request.getParameter("hiddenUserId"));
                UserRecord logUser = BlackjackService.getDataUser(userId);
                request.setAttribute("user", logUser);
                
                List<LogRecord> logUserArr = BlackjackService.getDataLogUser(userId);
                request.setAttribute("logUserArr", logUserArr);
                
                //Nieuwe data opvragen.
                int gameId = Integer.parseInt(request.getParameter("hiddenGameId"));
                List<LogRecord> logGameArr = BlackjackService.getDataLogGame(gameId);
                request.setAttribute("logGameArr", logGameArr);
                
                view = request.getRequestDispatcher("GebruikersbeheerLog.jsp");
                view.forward(request, response);
                break;
                
            case "TERUG":
                view = request.getRequestDispatcher("Gebruikersbeheer.jsp");
                view.forward(request, response);
                break;
            
        }  
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

}
