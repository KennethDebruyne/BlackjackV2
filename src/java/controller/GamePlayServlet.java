/*
    GAME PLAY SERVLET
    Servlet used during gameplay.
 */

package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.card.Hand;
import model.game.Game;
import model.player.Player;
import model.utilities.enumeration.*;

public class GamePlayServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");
        
        List<Player> playerArr = game.getPlayers();
        
        for (Player player : playerArr) {
            if (player.getUserName().toUpperCase().equals("DEALER")) {
                continue;
                
            }
            
            String radioValue = request.getParameter("option" + player.getUserName());
            if (radioValue != null) {
                Hand playerHand = player.getHand();
                
                switch (radioValue.toUpperCase()) {
                    case "HIT":
                        playerHand.setHandStatus(HandStatus.HIT);
                        break;

                    case "STAND":
                        playerHand.setHandStatus(HandStatus.STAND);
                        break;

                }
            
            }
                
        }

        game.runRound();
        if (game.isGameOver()) {
            determineProfits(playerArr);
            
            RequestDispatcher view = request.getRequestDispatcher("GameEnd.jsp");
            view.forward(request, response);
            
        }
        
        RequestDispatcher view = request.getRequestDispatcher("GameBord.jsp");
        view.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }
    
    //Method that determines who gets how much money after the game.
    private void determineProfits(List<Player> playerArr) {
        for (Player player : playerArr) {
            PlayerStatus playerStatus = player.getPlayerStatus();
            Hand playerHand = player.getHand();

            switch (playerStatus) {
                case BLACKJACK:
                    player.applyBet((int)(playerHand.getBet() * 2.5));
                    break;

                case WIN:
                    player.applyBet(playerHand.getBet() * 2);
                    break;

                case PUSH:
                    player.applyBet(0);
                    break;

                case LOSS:
                    player.applyBet(-playerHand.getBet());
                    break;

                default:
                    break;

            }
                
        }

    }

}
