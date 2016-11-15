<%-- 
    Document   : Gebruikersbeheer
    Created on : 14-Nov-2016, 13:26:18
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
        <title>Gebruikersbeheer</title>
        <link rel="stylesheet" type="text/css" href="Styles/AdminConfiguration.css">
    </head>
    <body>
        <h1>Gebruikersbeheer</h1>
        
        <h2>Overzicht</h2>
        
        <div>
            <table>
                <tr>
                    <th>Icon</th>
                    <th>User ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Balance</th>
                    <th>Options</th>
    
                </tr>
                
                <%
                    List<UserRecord> userArr = BlackjackService.getAllUsers();
                    
                    for (UserRecord user : userArr) {
                        out.print("<tr>");
                        
                        out.print("<td>");
                        out.print("<img src=\"" + user.getIconUri() + "\" /");
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print(user.getUserId());
                        out.print("</td>");
                                
                        out.print("<td>");
                        out.print(user.getFirstName());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print(user.getLastName());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print(user.getBalance());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print("<form action=\"BeheerServlet\" method=\"post\">"
                                + "<input type=\"hidden\" name=\"hiddenId\" value=\"" + user.getUserId() + "\" />"
                                + "<input type=\"submit\" id=\"log\" name=\"btnOption\" value=\"Log\" style=\"margin-right:35px\"/>"  
                                + "<input type=\"submit\" id=\"edit\" name=\"btnOption\" value=\"Edit\" />"
                                + "<input type=\"submit\" id=\"delete\" name=\"btnOption\" value=\"Delete\" />"
                                + "</form>");
                        
                        out.print("</td>");
                        
                        out.print("</tr>");
                        
                    }
                   
                %>
                
                <tr>
                    <td style='border-bottom:none'>
                        <form action="BeheerServlet" method="post">
                            <input type="submit" id="new" name="btnOption" value="New" />
                        </form>
                    </td>
                </tr>
                
            </table>
                
        </div>
                
    </body>
</html>
