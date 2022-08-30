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

import beans.BookBean;
import beans.IssueBookBean;
import dao.BookDao;
import java.util.List;

@WebServlet("/servlets.ViewIssuedBook")

/**
 *
 * @author adrianadewunmi
 */
public class ViewIssuedBook extends HttpServlet {


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
        out.println("<title>View Issued Book</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navlibrarian.html").include(request, response);
        
        out.println("<div class='container'>");
		
        List<IssueBookBean> list=BookDao.viewIssuedBook();

        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
        for(IssueBookBean bean:list){
                out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssuedate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
        }
        out.println("</table>");

        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
        
    }

}
