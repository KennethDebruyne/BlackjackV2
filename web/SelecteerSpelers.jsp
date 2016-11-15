<%-- 
    Document   : SelecteerSpelers
    Created on : 14-Nov-2016, 14:11:57
    Author     : Kenneth
--%>

<%@page import="java.util.List"%>
<%@page import="databank.model.UserRecord"%>
<%@page import="databank.service.BlackjackService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecteer spelers</title>
    </head>
    <body>
        <h1>Speel Blackjack</h1>
        
        <h2>Kies spelers</h2>
        
        <form action="GameStartServlet" method="post">            
            <%
                List<UserRecord> userArr = BlackjackService.getAllUsers();
                for (UserRecord userRecord : userArr) {
                    out.print("<select name=\"selectOption" + userRecord.getUserId() + "\" style=\"width: 215px; margin-right: 5px;\">");
                    out.print("<option value=\"none\"></option>");
                    out.print("<option value=\"" + userRecord.getUserId() + "\">" + userRecord.getFirstName() + " " + userRecord.getLastName() + "</option>");
                    out.print("</select>");
                    out.print("<input type=\"number\" name=\"txtBet" + userRecord.getUserId() + "\" value=\"0\" style=\"width: 30px;\" required />");
                    
                    out.print("<br />");
                    
                }

            %>
        
            <input type="submit" name="btnSubmit" value="Spelen" />
            
        </form>
        
    </body>
</html>
