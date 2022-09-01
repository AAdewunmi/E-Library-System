/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author adrianadewunmi
 */
import dao.LibrarianDao;
@WebServlet("/servlets.LibrarianLogin")

public class LibrarianLogin extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Librarian Section</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(LibrarianDao.authenticate(email, password)){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            request.getRequestDispatcher("navlibrarian.html").include(request, response);
            request.getRequestDispatcher("librariancarousel.html").include(request, response);
        }else{
            request.getRequestDispatcher("navhome.html").include(request, response);
            out.println("<div class='container'>");
            out.println("<h3>Username or password error</h3>");
            request.getRequestDispatcher("librarianloginform.html").include(request, response);
            out.println("</div>");
        }
        
        request.getRequestDispatcher("footer.html").include(request, response);
	out.close();
       
    }


}
