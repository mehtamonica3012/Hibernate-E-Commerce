/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJO.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Monica Mehta
 */
public class DoCart extends HttpServlet {

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
            int cart_id = Integer.parseInt(request.getParameter("cart_id"));
            String operation= request.getParameter("op");
            
            Session session= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
                String hql="";
            Cart c=(Cart) session.load(Cart.class,cart_id);
            c.setCartId(c.getCartId());
            c.setCustomerMaster(c.getCustomerMaster());
            c.setProductMaster(c.getProductMaster());
            
            if(operation.equals("incre"))
            {
//            int quantity=Integer.parseInt(request.getParameter("quantity"));
//                quantity+=1;
//                hql="update Cart c set c.quantity = "+quantity+" where c.cartId = "+cart_id;
                c.setQuantity(c.getQuantity()+1);
                session.update(c);
            }
            else if (operation.equals("decre"))             {
//            int quantity=Integer.parseInt(request.getParameter("quantity"));
//                quantity-=1;
//                hql="update Cart c set c.quantity = "+quantity+" where c.cartId = "+cart_id;
    c.setQuantity(c.getQuantity()-1);
    session.update(c);
            }
            else if(operation.equals("remove"))             {
//               hql="delete from Cart c where c.cartId= "+cart_id; 
                session.delete(c);
            }
            session.flush();
            tx.commit();
            session.close();
//            Query q=session.createQuery(hql);
           // tx.commit();
//            if(q.executeUpdate()!=0)
//            {               
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
//            }
//            else
//            {
//                out.println("<script type=\"text/javascript\">alert(\"Database Error.\");window.location=\"Cart.jsp\";</script>");
//            }            
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
