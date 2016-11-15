/*
    Log Out Servlet
    Servlet used for redirecting a user to the index page.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession session = request.getSession(false);
        session.invalidate();
        
        RequestDispatcher view = request.getRequestDispatcher("StartPagina.html");
        view.forward(request, response);  
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Verkeerde gegevens werden ingevoerd of geen toegang tot bepaalde site:
        response.sendRedirect("LogIn.html");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

}
