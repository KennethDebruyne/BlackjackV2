<%-- 
    Document   : GameBord
    Created on : 14-Nov-2016, 21:37:05
    Author     : Kenneth
--%>

<%@page import="java.util.List"%>
<%@page import="model.game.Game"%>
<%@page import="model.card.Hand"%>
<%@page import="model.card.Card"%>
<%@page import="model.player.Player"%>
<%@page import="model.utilities.enumeration.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blackjack</title>
    </head>
    <body>
        
        <form action="GamePlayServlet" method="post">
            <%
                final String IMAGE_PATH_BACK = "Images/Cards/CARDBACK.png";
                
                Game game = (Game) session.getAttribute("game");
                List<Player> playerArr = (List<Player>) game.getPlayers();

                for (Player player : playerArr) {
                    out.print("<img src=" + player.getIconUri() + " width=\"30\" height=\"30\"/>");
                    out.print(player.getUserName() + "<br />");
                    
                    Hand playerHand = player.getHand();
                    List<Card> cardArr = playerHand.getCards();
                    for (Card card : cardArr) {
                        if (card.isVisible()) {
                            out.print("<img src=" + card.getImagePath());
                            
                        }
                        else {
                            out.print("<img src=" + IMAGE_PATH_BACK);
                            
                        }
                        
                        out.print(" width=\"100\" height=\"175\" />");
                        
                    }
                    
                    out.print("<br />");
                    
                    if (!player.getUserName().toUpperCase().equals("DEALER")) {
                        HandStatus playerHandStatus = playerHand.getHandStatus();
                        
                        if (playerHandStatus != HandStatus.BUSTED && playerHandStatus != HandStatus.BLACKJACK) {
                            out.print("<input type=\"radio\" name=\"option" + player.getUserName() + "\" value=\"hit\" />Hit<br />");
                            out.print("<input type=\"radio\" name=\"option" + player.getUserName() + "\" value=\"stand\" />Stand<br />");
                            
                        }
                        else {
                            out.print("<input type=\"radio\" name=\"option" + player.getUserName() + "\" value=\"hit\" disabled />Hit<br />");
                            out.print("<input type=\"radio\" name=\"option" + player.getUserName() + "\" value=\"stand\" disabled />Stand<br />");
                            
                        }
                        
                    }
 
                }

            %>
            
            <br />
            <input type="submit" name="btnSubmit" value="Volgende ronde" />
            
        </form>
        
    </body>
</html>
