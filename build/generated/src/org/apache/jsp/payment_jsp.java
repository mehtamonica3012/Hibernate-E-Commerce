package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class payment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Footer.html");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <title>Payment Page</title>\n");
      out.write("        <style>\n");
      out.write("            header {\n");
      out.write("                position:fixed;\n");
      out.write("                height: 100px;\n");
      out.write("                width: 100%;\n");
      out.write("                left:0;\n");
      out.write("                right:0;\n");
      out.write("                top:0;\n");
      out.write("                background-image: linear-gradient(#020005, #090979,#00d4ff);\n");
      out.write("                margin:0;\n");
      out.write("                clear:both;\n");
      out.write("                z-index:10;\n");
      out.write("                padding-top:10px;\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("                padding-left:5px;\n");
      out.write("            }\n");
      out.write("            .anchor{  \n");
      out.write("                margin-top: 2px;\n");
      out.write("                height:514px;\n");
      out.write("                visibility:visible;\n");
      out.write("                width:100%;\n");
      out.write("                left:0;\n");
      out.write("                background-color: #CCC;\n");
      out.write("                right:0;               \n");
      out.write("                padding-top:0px;\n");
      out.write("                padding:0px;\n");
      out.write("                position:relative;\n");
      out.write("                display:block;\n");
      out.write("            }\n");
      out.write("            header img{\n");
      out.write("                background:transparent;\n");
      out.write("                float:left;\n");
      out.write("                visibility:visible;\n");
      out.write("                height:100px;\n");
      out.write("                width:100px;\n");
      out.write("            }\n");
      out.write("            header #name {\n");
      out.write("                font: 40px \"Arial\";\n");
      out.write("                display: inline;\n");
      out.write("                float:left;\n");
      out.write("                color: white;\n");
      out.write("                margin-left:10px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            header #cart{\n");
      out.write("                float:right;\n");
      out.write("                background: transparent;\n");
      out.write("                height:40px;\n");
      out.write("                width:60px;\n");
      out.write("                margin-right: 25px;\n");
      out.write("                margin-top: 25px;\n");
      out.write("            }\n");
      out.write("            #headcart h4{\n");
      out.write("                float:right;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color:white;\n");
      out.write("                vertical-align: middle;\n");
      out.write("                margin-top: 40px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #headcart h4 a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color:white;  \n");
      out.write("                margin-right: 15px;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            #headcart{\n");
      out.write("                vertical-align: middle;\n");
      out.write("                margin-right: 20px;\n");
      out.write("                height: 40px;\n");
      out.write("                float:right;\n");
      out.write("            }\n");
      out.write("            #headcart .logout\n");
      out.write("            {\n");
      out.write("                margin-top: 40px;\n");
      out.write("            }\n");
      out.write("            #headcart .logout a\n");
      out.write("            {\n");
      out.write("                text-decoration: none; \n");
      out.write("                color:white; \n");
      out.write("                float:right; \n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                width:100%;\n");
      out.write("                overflow:auto;\n");
      out.write("            }\n");
      out.write("            *{\n");
      out.write("                margin:0;\n");
      out.write("                padding:0;\n");
      out.write("            }\n");
      out.write("            #footer1{\n");
      out.write("\n");
      out.write("                bottom:0;\n");
      out.write("            }\n");
      out.write("            #cartproduct\n");
      out.write("            {\n");
      out.write("                width:100%;\n");
      out.write("                height:100%;\n");
      out.write("            }\n");
      out.write("            #headcart #navbar1\n");
      out.write("            {\n");
      out.write("                margin-left: 44%;\n");
      out.write("                position:relative;\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("            #navbar1 ul{\n");
      out.write("                list-style: none;\n");
      out.write("                float:right;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #navbar1 ul li h4{\n");
      out.write("                background-color: none;\n");
      out.write("                width: auto;\n");
      out.write("                height:30px;\n");
      out.write("                line-height: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("                float:left;\n");
      out.write("                color: white;\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                position:relative;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar1 ul li  a{\n");
      out.write("                text-decoration: none;\n");
      out.write("                color:black;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar1 ul li:hover > ul{\n");
      out.write("                display:block;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #navbar1 ul ul{\n");
      out.write("                align-self: flex-end;\n");
      out.write("                display:none;\n");
      out.write("                top:0px;\n");
      out.write("                margin-left: 30px;\n");
      out.write("                position:absolute;\n");
      out.write("                margin-top: 77px;\n");
      out.write("                z-index:1;\n");
      out.write("            }\n");
      out.write("            #dropUsername li{\n");
      out.write("                border: 1px inset white;\n");
      out.write("                padding: 10px;\n");
      out.write("                background: #f4f5f5;\n");
      out.write("            }\n");
      out.write("            i {\n");
      out.write("                border: solid white;\n");
      out.write("                border-width: 0 3px 3px 0;\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 3px;\n");
      out.write("                margin-bottom: 4px;\n");
      out.write("                transform: rotate(45deg);\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                margin-top: 200px;\n");
      out.write("                margin-bottom: 2%;         \n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                width:20%;\n");
      out.write("                vertical-align: middle;\n");
      out.write("                padding:10px;\n");
      out.write("            }\n");
      out.write("            #pimage\n");
      out.write("            {\n");
      out.write("                margin-top: 150px;\n");
      out.write("                valign:middle;\n");
      out.write("                align-self: center;\n");
      out.write("            }\n");
      out.write("            #ptmt b\n");
      out.write("            {\n");
      out.write("                font-size: 32px; font-style: italic; font-weight: bolder;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header1\">\n");
      out.write("            ");
 if (session.getAttribute("firstname") == null) {
      out.write("\n");
      out.write("            <header id=\"head\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.html", out, false);
      out.write("\n");
      out.write("            </header>\n");
      out.write("            ");
 } else {
      out.write("\n");
      out.write("\n");
      out.write("            <header id=\"head\">\n");
      out.write("                <img src=\"logo.png\"/>\n");
      out.write("                <h1 id=\"name\"><strong>MITESH MOBILE & ELECTRONICS</strong></h1>  \n");
      out.write("                <div id=\"navbar1\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("\n");
      out.write("                            <h4 style=\"margin-right: 30px; margin-top:45px; cursor:default;\">Hello, ");
      //  c:out
      org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
      _jspx_th_c_out_0.setPageContext(_jspx_page_context);
      _jspx_th_c_out_0.setParent(null);
      _jspx_th_c_out_0.setValue(session.getAttribute("firstname"));
      int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
      if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
        return;
      }
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      out.write(" &nbsp;<i></i></h4> &nbsp; &nbsp; \n");
      out.write("                            <ul id=\"dropUsername\">\n");
      out.write("                                <li>\n");
      out.write("\n");
      out.write("                                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ViewOrders.jsp\">View Orders</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("\n");
      out.write("                                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Logout\">Logout</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <a href=\"Cart.jsp\"><img src=\"cart1.png\" id=\"cart\"/></a>  \n");
      out.write("\n");
      out.write("                <div id=\"navbarid\" style=\"display:block;\"></div>\n");
      out.write("                <script>\n");
      out.write("                    $(\"#navbarid\").load(\"navigation.html\");\n");
      out.write("                </script>\n");
      out.write("            </header>\n");
      out.write("            ");
}
      out.write(" \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"paymentpage\">\n");
      out.write("            <div align=\"center\" style=\"margin-top: 100px;\" id=\"ptmt\">\n");
      out.write("                <b>\n");
      out.write("                    <h3><span style=\"font-size:30px; font-family:Arial, Helvetica, sans-serif; \">P</span>AYMENT</h3>\n");
      out.write("                </b>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <form method=\"post\" action=\"PPayment\">\n");
      out.write("                    <table border=\"0\" cellspacing=\"5px\" cellpadding=\"10px\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <img src=\"payment/payment2.png\" height=\"400px\">\n");
      out.write("                            </td>\n");
      out.write("                            <td align=\"left\">\n");
      out.write("                                Amount to be Paid: <input type=\"text\" name=\"amt\" disabled=\"true\"/> <br/><br/>\n");
      out.write("                                Enter Debit/Credit card number: <input type=\"text\" name=\"card\"/><br/><br/>\n");
      out.write("                                Enter CVV number: <input type=\"text\" name=\"cvv\"/><br/><br/>\n");
      out.write("                                Card Expiry:\n");
      out.write("                                Month:\n");
      out.write("                                <select name=\"month\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                Year: \n");
      out.write("                                <select name=\"year\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\" align=\"center\">\n");
      out.write("                                <input type=\"submit\" value=\"Submit\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer1\">\n");
      out.write("            ");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            footer{ \n");
      out.write("                width:100%;\n");
      out.write("                height:120px;   /* Height of the footer */\n");
      out.write("                background:linear-gradient(#141E30,#243B55);\n");
      out.write("                bottom:0;\n");
      out.write("                right:0;\n");
      out.write("                left: 0;\n");
      out.write("                clear:both;\n");
      out.write("                position:relative;\n");
      out.write("                display: block;\n");
      out.write("             }\n");
      out.write("             footer p{\n");
      out.write("                 vertical-align: middle;\n");
      out.write("                 color:whitesmoke;\n");
      out.write("                 padding-top: 15px;\n");
      out.write("                 text-align: center;\n");
      out.write("             }\n");
      out.write("             footer p a{\n");
      out.write("                 color:whitesmoke;\n");
      out.write("                 text-decoration: none;\n");
      out.write("             }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <footer>           \n");
      out.write("            <p>&copy; Mitesh Electronics\n");
      out.write("            <br/><br/>Contact Information: <b>8446901247</b><br/><br/>\n");
      out.write("            <a href=\"mailto:ronak.chhajed@somaiya.edu\">ronak.chhajed@somaiya.edu</a></p>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(12);
    _jspx_th_c_forEach_0.setVar("mnth");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mnth}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mnth}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setBegin(2019);
    _jspx_th_c_forEach_1.setEnd(2029);
    _jspx_th_c_forEach_1.setVar("year");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${year}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${year}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
