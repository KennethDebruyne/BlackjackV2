<%-- 
    Document   : GebruikersbeheerNew
    Created on : 14-Nov-2016, 13:36:01
    Author     : Kenneth
--%>

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
        
        <h2>Toevoegen</h2>
        
        <div>
            <form action="BeheerNewServlet" method="post">
                <p>
                    <%
                        out.print("First name: " + "<input type=\"text\" name=\"txtFirstName\" /> <br />");
                        out.print("Last name: " + "<input type=\"text\" name=\"txtLastName\" /> <br />");
                        out.print("Icon URI: " + "<input type=\"text\" name=\"txtIconUri\" /> <br />");
                        out.print("Password: " + "<input type=\"text\" name=\"txtPassword\" /> <br />");
                        out.print("Balance: " + "<input type=\"text\" name=\"txtBalance\" /> <br />");
                        
                    %>
                    
                    <br />
                    <input type="submit" name="btnOption" value="Toevoegen" />
                    <input type="submit" name="btnOption" value="Terug" />                           
                    
                </p>
                
            </form>
            
        </div>
        
    </body>
</html>
