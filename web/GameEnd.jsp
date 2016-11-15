<%-- 
    Document   : GameEnd
    Created on : 15-Nov-2016, 13:15:59
    Author     : Kenneth
--%>

<%@page import="java.util.List"%>
<%@page import="model.player.Player"%>
<%@page import="model.game.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blackjack</h1>
        
        <h2>Einde spel</h2>
        
        <%
            Game game = (Game) session.getAttribute("game");
            List<Player> playerArr = game.getPlayers();
            
            for (Player player : playerArr) {
                out.print(player.getUserName() + ": " + player.getPlayerStatus().toString());
                out.print("<br />");
                
            }

        %>
        
        <form action="StartPagina.html" method="post">
            <input type="submit" name="btnSubmit" value="Terug" />
        </form>
        
    </body>
</html>
