package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login123_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function div_login() {\n");
      out.write("            document.getElementById('login').style.display = \"block\";\n");
      out.write("            }\n");
      out.write("            window.onload=function(){\n");
      out.write("                div_login();\n");
      out.write("            };\n");
      out.write("            \n");
      out.write("                $(document).ready(function(){\n");
      out.write("                    setTimeout(function(){\n");
      out.write("                       div_login();\n");
      out.write("                    },5000); // 5000 to load it after 5 seconds from page load\n");
      out.write("                 });\n");
      out.write("           \n");
      out.write("            function div_hidelogin(){\n");
      out.write("            //document.getElementById('closebtn').this.parentNode.style.display = \"none\";\n");
      out.write("            document.getElementById('closebtn').addEventListener('click', function(e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    this.parentNode.parentNode.parentNode.style.display = 'none';\n");
      out.write("                }, false);\n");
      out.write("                window.location.href = \"HomePage.jsp\";\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            #login {\n");
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
      out.write("            div #popuplogin {\n");
      out.write("                position:absolute;\n");
      out.write("                left:35%;\n");
      out.write("                top:20%;\n");
      out.write("                height:300px;\n");
      out.write("                width:fit-content;\n");
      out.write("                margin-top:10px;\n");
      out.write("                background: linear-gradient(#5614B0,#DBD65C);\n");
      out.write("                z-index: 20;\n");
      out.write("                border-radius: 2%;\n");
      out.write("                border: 2px solid black;\n");
      out.write("                font-family:'Raleway',sans-serif\n");
      out.write("            }\n");
      out.write("            #closebtn \n");
      out.write("            {\n");
      out.write("                position:absolute;\n");
      out.write("                right: -18px;\n");
      out.write("                top: -15px;\n");
      out.write("                cursor:pointer;\n");
      out.write("                height:50px;\n");
      out.write("                width:50px;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            div #popuplogin table{\n");
      out.write("                background-color: snow;\n");
      out.write("                margin-inline-start: 20px;\n");
      out.write("                margin-inline-end: 20px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                border-radius: 2%;\n");
      out.write("                padding:10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"div_login()\">\n");
      out.write("        \n");
      out.write("        <div id=\"login\"> \n");
      out.write("            <div id=\"popuplogin\">                 \n");
      out.write("         <!--   <h2 style=\"color:red\"><b><center>Invalid email or password</center></b></h2>-->\n");
      out.write("                    <center>\n");
      out.write("                    <img id=\"closebtn\" src=\"closebutton.png\" onclick =\"div_hidelogin()\"/>\n");
      out.write("                    <table border=\"0\" cellspacing=\"2px\" cellpadding=\"5px\">                  \n");
      out.write("                    <form method=\"post\" action=\"login12\">\n");
      out.write("                        <caption style=\"margin-bottom:20px\"><h2 align=\"center\">Login</h2></caption>\n");
      out.write("                            <b>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                       Email: \n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                       <input type=\"text\" name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" title=\"Enter email in format abc12@something.com\" required/> \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                       Password: \n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"center\">\n");
      out.write("                                       <input type=\"password\" name=\"pswd\" required/> \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        \n");
      out.write("                                    </td>\n");
      out.write("                                    <td align=\"start\">\n");
      out.write("<!--                                        <input type=\"submit\" value=\"LOGIN\" align=\"center\" />-->\n");
      out.write("                                        <button type=\"submit\" value=\"LOGIN\"> <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login12?email=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&password=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.pswd}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"buybutton\" style=\"Visibility:visible;\">LOGIN</a></button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td></td>\n");
      out.write("                                    <td>\n");
      out.write("                                <a href=\"signup123.jsp\" style=\"color:blue;\"> New User? </a>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                \n");
      out.write("                            </b>\n");
      out.write("                        </center>\n");
      out.write("                    </form>    \n");
      out.write("                    </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
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
