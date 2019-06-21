package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup123_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function div_signup() {\n");
      out.write("            document.getElementById('signup').style.display = \"block\";\n");
      out.write("            }\n");
      out.write("            window.onload=function(){\n");
      out.write("                div_signup();\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("                $(document).ready(function(){\n");
      out.write("                    setTimeout(function(){\n");
      out.write("                       div_signup();\n");
      out.write("                    },5000); // 5000 to load it after 5 seconds from page load\n");
      out.write("                 });\n");
      out.write("           \n");
      out.write("            function div_hidesignup(){\n");
      out.write("            //document.getElementById('closebtn').this.parentNode.style.display = \"none\";\n");
      out.write("            document.getElementById('closebtn1').addEventListener('click', function(e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    this.parentNode.parentNode.parentNode.style.display = 'none';\n");
      out.write("                }, false);\n");
      out.write("                window.location.href = \"HomePage.jsp\";\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            #signup {\n");
      out.write("                width:100%;\n");
      out.write("                height:100%;\n");
      out.write("                opacity:.95;\n");
      out.write("                top:0;\n");
      out.write("                left:0;\n");
      out.write("                display:none;\n");
      out.write("                position:fixed;\n");
      out.write("                background-color:#313131;\n");
      out.write("                overflow:auto;\n");
      out.write("                z-index: 20;\n");
      out.write("            }\n");
      out.write("            div #popupsignup {\n");
      out.write("                position:absolute;\n");
      out.write("                left:35%;\n");
      out.write("                top:20%;\n");
      out.write("                height:500px;\n");
      out.write("                width:fit-content;\n");
      out.write("                background: linear-gradient(#5614B0,#DBD65C);\n");
      out.write("                z-index: 20;\n");
      out.write("                border-radius: 2%;\n");
      out.write("                border: 2px solid black;\n");
      out.write("                font-family:'Raleway',sans-serif\n");
      out.write("            }\n");
      out.write("            #closebtn1\n");
      out.write("            {\n");
      out.write("                position:absolute;\n");
      out.write("                right: -16px;\n");
      out.write("                top: -16px;\n");
      out.write("                cursor:pointer;\n");
      out.write("                height:50px;\n");
      out.write("                width:50px;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            div #popupsignup table{\n");
      out.write("                background-color: snow;\n");
      out.write("                margin-inline-start: 20px;\n");
      out.write("                margin-inline-end: 20px;\n");
      out.write("                margin-top:-10px;\n");
      out.write("                border-radius: 2%;\n");
      out.write("                padding:10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"div_signup()\">\n");
      out.write("        <div id=\"signup\">\n");
      out.write("            <div id=\"popupsignup\">\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <center>\n");
      out.write("                    <img id=\"closebtn1\" src=\"closebutton.png\" onclick =\"div_hidesignup()\"/>\n");
      out.write("                    <table border=\"0\" cellspacing=\"2px\" cellpadding=\"5px\">\n");
      out.write("                    <form method=\"post\" action=\"signup12\">\n");
      out.write("                        <caption style=\" margin-top: 4px;\"><h2 align=\"center\">Registration</h2></caption>\n");
      out.write("                        \n");
      out.write("                            <b>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        FirstName: \n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"fname\" pattern=\"[A-Za-z]+\"\n");
      out.write("                                                        title=\"Enter Valid FirstName\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        LastName:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"lname\" pattern=\"[A-Za-z]+\"\n");
      out.write("                                                        title=\"Enter Valid LastName\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Contact:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"number\" name=\"contak\" pattern=\"[26789][0-9]{9}\" maxlength=\"10\" title=\"Enter the contact starting with 7/8/9 and followed by more 9 digits\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Address Line1:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"addline1\" title=\"Enter address in format Flat no.,Bldg name,Local area name\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Address Line2:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"addline2\" title=\"Enter city\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Address Line3:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"addline3\" title=\"Enter state\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        PINCODE:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"number\" name=\"pin\" pattern=\"[0-9]{5}\" maxlength=\"6\" title=\"Enter a valid Pincode\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Email:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"text\" name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" title=\"Enter email in format abc12@something.com\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Password:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"password\" name=\"pswd\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        Confirm Password:\n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                        <input type=\"password\" name=\"cnpswd\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td></td>\n");
      out.write("                                    <td align=\"start\">\n");
      out.write("                                        <input type=\"submit\" value=\"SUBMIT\"/>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </b>\n");
      out.write("                        </center>\n");
      out.write("                    </form>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
