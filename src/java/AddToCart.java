    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJO.Cart;
import POJO.CustomerMaster;
import POJO.ProductMaster;
import static com.sun.xml.ws.api.message.Packet.Status.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
public class AddToCart extends HttpServlet {

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
                String cat=request.getParameter("category");
                String subcat=request.getParameter("sub_category");
                String url="Sidenavbar11?category="+request.getParameter("category")+"&sub_category="+request.getParameter("sub_category");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCart</title>"); 
           // out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
            //out.println("");
                out.println("</head>");
                    out.println("<body>");
            if(session.getAttribute("firstname")==null)
            {
                RequestDispatcher rd=request.getRequestDispatcher("login123.jsp");
                rd.forward(request, response);
            }
            else
            {
                String prid=request.getParameter("prid");
                System.out.println(prid);
                int productid=Integer.parseInt(request.getParameter("prid"));
                int customerid=Integer.parseInt(session.getAttribute("custid").toString());
                int qty=1;
                Session sess=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
                Transaction tx=sess.beginTransaction();
                //check in-stock or not 
                
                //check if prduct already in customer's cart
                Query query= sess.createQuery("from Cart c where c.customerMaster.customerId = "+customerid+ " and c.productMaster.productId="+productid);
                if(query.uniqueResult()!=null)
                {                    
                    
                    //out.println("window.location="+url+";");
                                       
//                    out.println("<script>alert('Product Already added to Cart');<br> <a href='Cart.jsp'>Cart Page</a>'</script>");
                        out.println("<script type=\"text/javascript\">alert(\"Product is already in Cart\");window.location=\""+url+"\";</script>");
//                    RequestDispatcher rd1=request.getRequestDispatcher("Sidenavbar11?category="+cat+"&sub_category="+subcat);
//                    rd1.forward(request, response);
                    //response.wait();
                 //   response.sendRedirect(url);
                    //out.println("</body>");
                }
                else
                {
                    Cart cr=(Cart)new Cart();
                    CustomerMaster customerMaster=new  CustomerMaster();
                    customerMaster.setCustomerId(customerid);
                    cr.setCustomerMaster(customerMaster);
                    ProductMaster pm=new ProductMaster();
                    pm.setProductId(productid);
                    cr.setProductMaster(pm);
                    cr.setQuantity(qty);                    
                    if(sess.save(cr)!=null)
                    {
                    sess.flush();
                    tx.commit();                    
//                    out.println("<script language='text/javascript'>alert('Product Successfully added to Cart. <br> <a href='Cart.jsp'>Cart Page</a>');</script>");
                    
                        out.println("<script type=\"text/javascript\">alert(\"Product Successfully added to Cart\");window.location=\""+url+"\";</script>");
                    //out.println("window.location="+url+";");
                    
                    }
                    else
                    {                 
                        
//                        out.println("<script language='text/javascript'>alert('Product adding to Cart Failed. <br> <a href='Cart.jsp'>Cart Page</a>');</script>");
                        out.println("<script type=\"text/javascript\">alert(\"Product adding to Cart Failed\");window.location=\""+url+"\";</script>");
                        
                        //out.println("window.location="+url+";");
                        
                    }
                    //String url="Sidenavbar11?category="+cat+"&sub_category="+subcat;                    
//                    RequestDispatcher rd2=request.getRequestDispatcher("Sidenavbar11?category="+cat+"&sub_category="+subcat);
//                    rd2.forward(request, response);
                   // response.sendRedirect("Sidenavbar11?category="+cat+"&sub_category="+subcat);
                   // response.sendRedirect(url);
                   sess.close();
                }
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
