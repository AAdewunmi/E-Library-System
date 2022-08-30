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
import beans.*;
import dao.*;
import java.util.List;

@WebServlet("/servlets.ViewBook")

public class ViewBook extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>View Book</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
       
        request.getRequestDispatcher("navlibrarian.html").include(request, response);
        
        out.println("<div class='container'>");
        
        List<BookBean> list = BookDao.view();
        
        out.println("<table class='table table-bordered table-striped'>");
	out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
        
        for(BookBean bean:list){
            out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallno()+"'>Delete</a></td></tr>");
	}
        
        out.println("</table>");
		
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }

}
