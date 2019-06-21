/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJO.CustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Monica Mehta
 */
public class login12 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String pswd = request.getParameter("pswd");

            Configuration c = new Configuration();
            c.configure("hibernate.cfg.xml");
            SessionFactory sf = c.buildSessionFactory();
            Session s = sf.openSession();
            CustomerMaster cm = new CustomerMaster();

            String hql = "From CustomerMaster C where C.email='" + email + "' and C.password='" + pswd + "'";
            Query qry = s.createQuery(hql);
            List<CustomerMaster> results = qry.list();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login12</title>");
            out.println("</head>");
            out.println("<body>");
            if (results.isEmpty()) {
                out.println("<script type=\"text/javascript\">alert(\"Invalid Username or Password. Login Again.\");window.location=\"login123.jsp\";</script>");
                //    response.sendRedirect("HomePage.jsp?#error");
//                RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
//                rd.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                for (CustomerMaster C : results) {
                    session.setAttribute("firstname", C.getFirstName());
                    session.setAttribute("custid",C.getCustomerId());
                }
                RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
                rd.forward(request, response);

            }

            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
