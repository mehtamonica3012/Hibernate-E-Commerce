/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJO.Cart;
import POJO.CustomerMaster;
import POJO.OrderDetail;
import POJO.OrderMaster;
import POJO.ProductMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Monica Mehta
 */
public class Order extends HttpServlet {

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
            HttpSession session=request.getSession();
            int custid=Integer.parseInt(session.getAttribute("custid").toString());
            Session sess=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
            Transaction tx=sess.beginTransaction();
            OrderMaster om=new OrderMaster();
            CustomerMaster cm= (CustomerMaster)sess.load(CustomerMaster.class, custid);
//            cm.setCustomerId(custid);
            om.setCustomerMaster(cm);
            om.setIsDelivered('N');
            double price;
           // String qty=request.getParameter("quantity");
            
            int qtty=Integer.parseInt(request.getParameter("quantity"));
            if(sess.save(om)!=null)
                {
                    int orderid=om.getOrderId();
                    OrderDetail od=new OrderDetail();
                    om.setOrderId(orderid);
                    od.setOrderMaster(om);
                String hql="From Cart c where c.customerMaster.customerId="+custid;
                Query qry=sess.createQuery(hql);
                List<Cart> ls=qry.list();
                for (Cart cart : ls) {
                    //Cart cart;                    
                    //od.setOrderMaster(om);
                       // cart = (Cart)c;
                    OrderDetail od1=new OrderDetail();
                    ProductMaster pm=new ProductMaster();
                    int prddid=cart.getProductMaster().getProductId();
                    pm.setProductId(prddid);
                    od1.setProductMaster(cart.getProductMaster());
                    od1.setOrderMaster(om);
                    
                    od1.setQuantity(cart.getQuantity());
                    double tPrice=cart.getProductMaster().getPrice();
                    double discount=cart.getProductMaster().getCategoryDiscount();
                    price=tPrice-(tPrice*discount/100);
                    od1.setPrice(price);
                    sess.save(od1);
                    sess.flush();
                    sess.delete(cart);
                }
                tx.commit();
                double totalcart=Double.parseDouble(request.getParameter("cart_total"));
                out.println("<script type=\"text/javascript\">alert(\"Order confirmed! Proceed to Pay..!\");window.location=\"payment.jsp?totalcart="+totalcart+"\";</script>");
               // request.getRequestDispatcher("payment.jsp").forward(request, response);
            }
            else
            {
                out.println("<script type=\"text/javascript\">alert(\"Order not confirmed!\");window.location=\"Order.jsp\";</script>");
            }
            
         /*   out.println("<div align='center'>"
                    + "<img src='payment/face.gif' height='200px'/>"
                    + "<br/>"
                    + "<img src='payment/giphy.gif'/>"
                    + "<br/>");
            out.println("<a href='Payment.jsp' align='center' style='-webkit-appearance:button; background-color:#0570BD; font-size: 20px;\n" +
"                padding: 14px 40px;\n" +
"                border-radius: 12px;\n" +
"                color:white;\n" +
"                font-style: bold;'>Proceed to Pay</a></div>");
            */
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
