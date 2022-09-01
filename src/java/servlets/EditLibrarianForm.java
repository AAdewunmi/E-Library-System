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

@WebServlet("/servlets.EditLibrarianForm")
public class EditLibrarianForm extends HttpServlet {


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
        PrintWriter out=response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Edit Librarian Form</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("navadmin.html").include(request, response);
        out.println("<div class='container'>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        LibrarianBean bean=LibrarianDao.viewById(id);
        
        out.print("<form action='servlets.EditLibrarian' method='post' style='width:300px'>");
        out.print("<div class='form-group'>");
        out.print("<input type='hidden' name='id' value='"+ bean.getLibrarianID()+"'/>");
        out.print("<label for='name1'>Name</label>");
        out.print("<input type='text' class='form-control' value='"+bean.getLibrarianName()+"' name='name' id='name1' placeholder='Name'/>");
        out.print("</div>");
        out.print("<div class='form-group'>");
        out.print("<label for='email1'>Email address</label>");
        out.print("<input type='email' class='form-control' value='"+bean.getLibrarianEmail()+"'  name='email' id='email1' placeholder='Email'/>");
        out.print("</div>");
        out.print("<div class='form-group'>");
        out.print("<label for='password1'>Password</label>");
        out.print("<input type='password' class='form-control' value='"+bean.getLibrarianPassword()+"'  name='password' id='password1' placeholder='Password'/>");
        out.print("</div>  ");
        out.print("<div class='form-group'>");
        out.print("<label for='mobile1'>Mobile Number</label>");
        out.print("<input type='number' class='form-control' value='"+bean.getLibrarianMobileNumber()+"'name='mobile' id='mobile1' placeholder='Mobile'/>");
        out.print("</div>");
        out.print("<button type='submit' class='btn btn-primary'>Update</button>");
        out.print("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }

}
