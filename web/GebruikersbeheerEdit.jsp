<%-- 
    Document   : GebruikersbeheerEdit
    Created on : 14-Nov-2016, 13:33:16
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
    </head>
    <body>
        <h1>Gebruikersbeheer</h1>
        
        <h2>Aanpassen</h2>
        
        <div>
            <form action="BeheerEditServlet" method="post">
                <p>
                    <%
                        UserRecord editedUser = (UserRecord) request.getAttribute("user");
                        
                        out.print("<input type=\"hidden\" name=\"hiddenId\" value=\"" + editedUser.getUserId()+ "\" /> <br />");
                        out.print("First name: " + "<input type=\"text\" name=\"txtFirstName\" value=\"" + editedUser.getFirstName() + "\" /> <br />");
                        out.print("Last name: " + "<input type=\"text\" name=\"txtLastName\" value=\"" + editedUser.getLastName() + "\" /> <br />");
                        out.print("Icon URI: " + "<input type=\"text\" name=\"txtIconUri\" value=\"" + editedUser.getIconUri() + "\" /> <br />");
                        out.print("Balance: " + "<input type=\"text\" name=\"txtBalance\" value=\"" + editedUser.getBalance() + "\" /> <br />");
                        
                    %>
                    
                    <br />
                    <input type="submit" name="btnOption" value="Aanpassen" />
                    <input type="submit" name="btnOption" value="Terug" />                           
                    
                </p>
                
            </form>
            
        </div>
        
    </body>
</html>
