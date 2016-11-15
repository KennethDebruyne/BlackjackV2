<%-- 
    Document   : GebruikersbeheerDelete
    Created on : 14-Nov-2016, 13:34:13
    Author     : Kenneth
--%>

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
        
        <h2>Verwijderen</h2>
        
        <div>
            <form action="BeheerDeleteServlet" method="post">
                <p>
                    <%
                        UserRecord deletedUser = (UserRecord) request.getAttribute("user");
                        
                        out.print("User ID: <input type=\"text\" id=\"disabledStyle\" name=\"txtUserId\" value=\"" + deletedUser.getUserId()+ "\" readonly /> <br />");
                        out.print("First name: " + "<input type=\"text\" id=\"disabledStyle\" name=\"txtFirstName\" value=\"" + deletedUser.getFirstName() + "\" readonly /> <br />");
                        out.print("Last name: " + "<input type=\"text\" id=\"disabledStyle\" name=\"txtLastName\" value=\"" + deletedUser.getLastName() + "\" readonly /> <br />");
                        out.print("Icon URI: " + "<input type=\"text\" id=\"disabledStyle\" name=\"txtIconUri\" value=\"" + deletedUser.getIconUri() + "\" readonly /> <br />");
                        out.print("Balance: " + "<input type=\"text\" id=\"disabledStyle\" name=\"txtBalance\" value=\"" + deletedUser.getBalance() + "\" readonly /> <br />");
                        
                    %>
                    
                    <br />
                    <input type="submit" id="noStyle" name="btnOption" value="Verwijderen" />
                    <input type="submit" id="noStyle" name="btnOption" value="Terug" />                           
                    
                </p>
                
            </form>
        
    </body>
</html>
