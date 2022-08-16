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
import beans.LibrarianBean;
import dao.LibrarianDao;
import java.util.List;

@WebServlet("/servlets.ViewLibrarian")

public class ViewLibrarian extends HttpServlet {

    

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
        out.println("<title>View Librarian</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css/'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js/'></script>");
        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js/'></script>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navadmin.html").include(request, response);
        out.println("<div class='container'>");
        List<LibrarianBean> list=LibrarianDao.view();
        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
        for(LibrarianBean bean:list){
                out.println("<tr><td>"+bean.getLibrarianID()+"</td><td>"+bean.getLibrarianName()+"</td><td>"+bean.getLibrarianEmail()+"</td><td>"+bean.getLibrarianPassword()+"</td><td>"+bean.getLibrarianMobileNumber()+"</td><td><a href='servlets.EditLibrarianForm?id="+bean.getLibrarianID()+"'>Edit</a></td><td><a href='servlets.DeleteLibrarian?id="+bean.getLibrarianID()+"'>Delete</a></td></tr>");
        }
        out.println("</table>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
		
    }

}
