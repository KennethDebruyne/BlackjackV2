<%-- 
    Document   : GebruikersbeheerLog
    Created on : 14-Nov-2016, 13:30:17
    Author     : Kenneth
--%>

<%@page import="java.util.List"%>
<%@page import="databank.model.LogRecord"%>
<%@page import="databank.model.UserRecord"%>
<%@page import="databank.service.BlackjackService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gebruikersbeheer</title>
        <link rel="stylesheet" type="text/css" href="Styles/AdminConfiguration.css">
    </head>
    <body>
        <h1>Gebruikersbeheer</h1>
        
        <h2>Logs</h2>
        
        <div>
            <p>
            <h3>Speler:</h3>

                <table>
                        <tr>
                            <th>Icon</th>
                            <th>User ID</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Balance</th>

                        </tr>

                <%
                    UserRecord logUser = (UserRecord) request.getAttribute("user");
                    int userId = logUser.getUserId();

                    out.print("<tr>");

                    out.print("<td>");
                    out.print("<img src=\"" + logUser.getIconUri() + "\" /");
                    out.print("</td>");

                    out.print("<td>");
                    out.print(userId);
                    out.print("</td>");

                    out.print("<td>");
                    out.print(logUser.getFirstName());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(logUser.getLastName());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(logUser.getBalance());
                    out.print("</td>");

                    out.print("</tr>");

                %>

                </table>

            </p>

            <br />
            <hr />
            <br />
                    
        </div>
              
        <div>
            <p>
            <h3>Logs: </h3>
                    <table>
                        <tr>
                            <th>Log ID</th>
                            <th>Game ID</th>
                            <th>Bet</th>
                            <th>Hand value</th>
                            <th>Player status</th>
                            <th>Options</th>

                        </tr>
                        
                        <%
                            List<LogRecord> logUserArr = (List<LogRecord>) request.getAttribute("logUserArr");
                            for (LogRecord log : logUserArr) {
                                int gameId = log.getGameId();
   
                                out.print("<tr>");

                                out.print("<td>");
                                out.print(log.getLogId());
                                out.print("</td>");

                                out.print("<td>");
                                out.print(gameId);
                                out.print("</td>");

                                out.print("<td>");
                                out.print(log.getBet());
                                out.print("</td>");

                                out.print("<td>");
                                out.print(log.getHandValue());
                                out.print("</td>");

                                out.print("<td>");
                                out.print(log.getPlayerStatusString());
                                out.print("</td>");
                                
                                out.print("<td>");
                                out.print("<form action=\"BeheerLogServlet\" method=\"post\">"
                                        + "<input type=\"hidden\" name=\"hiddenUserId\" value=\"" + userId + "\" /> <br />"
                                        + "<input type=\"hidden\" name=\"hiddenGameId\" value=\"" + gameId + "\" />"
                                        + "<input type=\"submit\" id=\"details\" name=\"btnOption\" value=\"Details\" />"
                                        + "</form>");
                                out.print("</td>");
                                
                                out.print("</tr>");
                                
                            }
  
                        %>
   
                </table>

            </p>

        </div>
                        
        <div>
            <%
                //Enkel als er gevraagd wordt om extra details te tonen van een game.
                List<LogRecord> logGameArr = (List<LogRecord>) request.getAttribute("logGameArr");
                if (logGameArr != null) {
                    out.print("<br />");
                    out.print("<hr />");
                    out.print("<br />");

                    out.print("<h3>Game details:</h3>");
                    
                    out.print("<table>");
                    
                    out.print("<th>Log ID</th>");
                    out.print("<th>Game ID</th>");
                    out.print("<th>Player name</th>");
                    out.print("<th>Bet</th>");
                    out.print("<th>Hand value</th>");
                    out.print("<th>Player Status</th>");

                    for (LogRecord log : logGameArr) {
                        out.print("<tr>");

                        out.print("<td>");
                        out.print(log.getLogId());
                        out.print("</td>");

                        out.print("<td>");
                        out.print(log.getGameId());
                        out.print("</td>");

                        out.print("<td>");

                        int logUserId = log.getUserId();
                        UserRecord u = BlackjackService.getDataUser(logUserId);
                        String userName = u.getFirstName() + " " + u.getLastName();

                        out.print(userName);
                        out.print("</td>");

                        out.print("<td>");
                        out.print(log.getBet());
                        out.print("</td>");

                        out.print("<td>");
                        out.print(log.getHandValue());
                        out.print("</td>");

                        out.print("<td>");
                        out.print(log.getPlayerStatusString());
                        out.print("</td>");

                        out.print("</tr>");

                    }
                    
                    out.print("</table");

                }

            %>

        </div>
                
        <br />
        <form action="BeheerLogServlet" method="post">
            <input type="submit" id="noStyle" name="btnOption" value="Terug" />
        </form>
        
    </body>
</html>
