/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJO.CustomerMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Monica Mehta
 */
public class signup12 extends HttpServlet {

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
            String firstnm = request.getParameter("fname");
            String lastnm = request.getParameter("lname");
            String contack = request.getParameter("contak");
            String addline1 = request.getParameter("addline1");
            String addline2 = request.getParameter("addline2");
            String addline3 = request.getParameter("addline3");
            int pincode = Integer.parseInt(request.getParameter("pin"));
            String email = request.getParameter("email");
            String pass = request.getParameter("pswd");
            String cnfmpass = request.getParameter("cnpswd");

            Configuration c = new Configuration();
            c.configure("hibernate.cfg.xml");
            SessionFactory sf = c.buildSessionFactory();
            Session s = sf.openSession();
            Transaction tx = s.beginTransaction();

            CustomerMaster cm = new CustomerMaster();
            cm.setFirstName(firstnm);
            cm.setLastName(lastnm);
            cm.setContactNo(contack);
            cm.setAddressLine1(addline1);
            cm.setAddressLine2(addline2);
            cm.setAddressLine3(addline3);
            cm.setEmail(email);
            cm.setPincode(pincode);
            //cm.setPincode(pincode);
            if (pass.equals(cnfmpass)) {
                cm.setPassword(pass);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("signup123.jsp");
                rd.include(request, response);
            }
            s.save(cm);
            s.flush();
            tx.commit();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signup12</title>");
            out.println("</head>");
            out.println("<body>");

            RequestDispatcher rd = request.getRequestDispatcher("login123.jsp");
            rd.include(request, response);
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
