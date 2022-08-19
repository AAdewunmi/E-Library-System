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

import beans.*;
import dao.*;

/**
 *
 * @author adrianadewunmi
 */

@WebServlet("/servlets.AddBook")

public class AddBook extends HttpServlet {

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
        out.println("<title>Add Book Form</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css/'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js/'></script>");
        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js/'></script>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navlibrarian.html").include(request, response);
        
        out.println("<div class='container'>");
        String callno=request.getParameter("callno");
        String name=request.getParameter("name");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");
        String squantity=request.getParameter("quantity");
        int quantity=Integer.parseInt(squantity);
        
        BookBean bean=new BookBean(callno,name,author,publisher,quantity);
        int i=BookDao.save(bean);
        if(i>0){
                out.println("<h3>Book saved successfully</h3>");
        }
        request.getRequestDispatcher("addbookform.html").include(request, response);
        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
       
    }

}
