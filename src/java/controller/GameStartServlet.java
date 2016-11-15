/*
    GAME START SERVLET
    Servlet used for getting the players who want to play and initializing the game.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databank.model.*;
import databank.service.BlackjackService;
import javax.servlet.RequestDispatcher;
import model.game.Game;

public class GameStartServlet extends HttpServlet {

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
        
        List<UserRecord> userArr = BlackjackService.getAllUsers();
        List<UserRecord> selectedUsersArr = new ArrayList();
        
        for (UserRecord userRecord : userArr) {
            String optionValue = request.getParameter("selectOption" + Integer.toString(userRecord.getUserId()));
            
            if (!optionValue.toUpperCase().equals("NONE")) {
                String textBoxValue = request.getParameter("txtBet" + Integer.toString(userRecord.getUserId()));
                userRecord.setBet(Integer.valueOf(textBoxValue));
                
                selectedUsersArr.add(userRecord);
                
            }
            
        }
        
        Game game = new Game(selectedUsersArr);
        HttpSession session = request.getSession();
        session.setAttribute("game", game);
        
        RequestDispatcher view = request.getRequestDispatcher("GameBord.jsp");
        view.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

}
