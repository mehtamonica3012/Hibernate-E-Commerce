/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Monica Mehta
 */
public class Sidenavbar11 extends HttpServlet {

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
            String selectprice[]=request.getParameterValues("chk1");
            //int plen=selectprice.length;
            String  selectbrand[]=request.getParameterValues("chkbrand");
            
            String selectdiscount[]=request.getParameterValues("chkd1");
            
           String category=request.getParameter("category");
           String sub_category=request.getParameter("sub_category");
           String queryurl="";
           if(request.getParameter("category").equals("All")) 
           {
               queryurl="select * from product_master limit 10";
           }
           else if(request.getParameter("category").equals("Products")) 
           {
               queryurl="select * from product_master where category_id in (select category_id from category_master where category_name='Phone' or category_name='Laptop')";
           }
           else if(request.getParameter("sub_category").equals("all")) 
           {
               queryurl="select * from product_master where category_id = (select category_id from category_master where category_name='"+category+"')";
           }
           else
           {
               queryurl="select * from product_master where category_id = (select category_id from category_master where category_name='"+category+"') and sub_category_id=(select sub_category_id from sub_category_master where sub_category_name='"+sub_category+"')";
           }
           
            
            
            if (selectprice!=null){
                queryurl=queryurl.concat(" and ( ");
             
                for(int i=0;i<selectprice.length-1;i++)        
                    {
                    switch (selectprice[i]){
                           case "1500-5000":
                                queryurl=queryurl.concat(" price between 1500 and 5000 or ");
                               break;
                           case "5000-10000":
                               queryurl=queryurl.concat(" price between 5000 and 10000 or ");
                             break;
                           case "10000-15000":
                               queryurl=queryurl.concat(" price between 10000 and 15000 or ");
                             break;
                           case "15000 & above":
                               queryurl=queryurl.concat(" price >= 15000 or ");
                             break;
                       }
              }
                 switch (selectprice[(selectprice.length-1)]){
                           case "1500-5000":
                                queryurl=queryurl.concat(" price between 1500 and 5000 ");
                               break;
                           case "5000-10000":
                               queryurl=queryurl.concat(" price between 5000 and 10000 ");
                             break;
                           case "10000-15000":
                               queryurl=queryurl.concat(" price between 10000 and 15000 ");
                             break;
                           case "15000 & above":
                               queryurl=queryurl.concat(" price >= 15000 ");
                             break;
                       }
             
             queryurl=queryurl.concat(" ) ");
                //
            }
        //    queryurl=queryurl.concat(" price = "+selectprice[selectprice.length-1]+" ) ");
            
            if(selectbrand!=null){
queryurl=queryurl.concat(" and ( ");
                for(int j=0;j<selectbrand.length-1;j++)
                {
                    queryurl=queryurl.concat(" brand_id = "+selectbrand[j]+ " or ");
                }
                    queryurl=queryurl.concat(" brand_id = "+selectbrand[selectbrand.length-1] +") ");
            }
            
if(selectdiscount!=null){            
queryurl=queryurl.concat(" and ( ");
            for(int k=0;k<selectdiscount.length-1;k++)
            {
                    switch(selectdiscount[k]){
                        case "0-10":
                            queryurl=queryurl.concat(" category_discount between 0 and 10 or ");
                            break;
                        case "11-20":
                            queryurl=queryurl.concat(" category_discount between 11 and 20 or ");
                            break;
                        case "21-30":
                            queryurl=queryurl.concat(" category_discount between 21 and 30 or ");
                            break;
                        case "31-40":
                            queryurl=queryurl.concat(" category_discount between 31 and 40 or ");
                            break;
                    }
            }
            switch(selectdiscount[selectdiscount.length-1]){
                        case "0-10":
                            queryurl=queryurl.concat(" category_discount between 0 and 10 ");
                            break;
                        case "11-20":
                            queryurl=queryurl.concat(" category_discount between 11 and 20  ");
                            break;
                        case "21-30":
                            queryurl=queryurl.concat(" category_discount between 21 and 30or ");
                            break;
                        case "31-40":
                            queryurl=queryurl.concat(" category_discount between 31 and 40 ");
                            break;
                    }
            queryurl=queryurl.concat(")");
}
                       queryurl=queryurl.concat(";");

           request.setAttribute("query", queryurl); 
           
           RequestDispatcher rd=request.getRequestDispatcher("electronics06.jsp?category="+category+"&sub_category="+sub_category);
          rd.forward(request, response);
           
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//
//            out.println("</head>");
//            out.println("<body> heello");
//           
//            out.println("</body>");
//            out.println("</html>");

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
