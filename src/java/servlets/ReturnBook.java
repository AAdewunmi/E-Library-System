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
import dao.BookDao;
/**
 *
 * @author adrianadewunmi
 */
@WebServlet("/servlets.ReturnBook")
public class ReturnBook extends HttpServlet {

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
        PrintWriter out=response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Return Book</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css/'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js/'></script>");
        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js/'></script>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navlibrarian.html").include(request, response);
        
        out.println("<div class='container'>");
        String callno=request.getParameter("callno");
        String sstudentid=request.getParameter("studentid");
        
        int studentid;
        studentid = Integer.parseInt(sstudentid);
        int i=BookDao.returnBook(callno,studentid);
        
        if(i>0){
                out.println("<h3>Book returned successfully</h3>");
        }else{
                out.println("<h3>Sorry, unable to return book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
        }
        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }


}
