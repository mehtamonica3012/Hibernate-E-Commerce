<%-- 
    Document   : Accessories06
    Created on : May 19, 2019, 2:11:54 AM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Accessories Page</title>
        <style>
            header {
                position:fixed;
                height: 100px;
                width: 100%;
                left:0;
                right:0;
                top:0;
                background-image: linear-gradient(#020005, #090979,#00d4ff);
                margin:0;
                clear:both;
                z-index:10;
                padding-top:10px;
                padding-bottom: 10px;
                padding-left:5px;
            }

            header img{
                background:transparent;
                float:left;
                visibility:visible;
                height:100px;
                width:100px;
            }
            header #name {
                font: 40px "Arial";
                display: inline;
                float:left;
                color: white;
                margin-left:10px;
                margin-top: 20px;
            }
            header #cart{
                float:right;
                background: transparent;
                height:40px;
                width:60px;
                margin-right: 25px;
                margin-top: 25px;
            }
            #headcart h4{
                float:right;
                text-decoration: none;
                color:white;
                vertical-align: middle;
                margin-top: 32px;

            }
            #headcart h4 a{
                text-decoration: none;
                color:white;  
                margin-right: 15px;
                vertical-align: middle;
            }
            #headcart{
                vertical-align: middle;
                margin-right: 20px;
                height: 40px;
                float:right;
            }
            body{
                width:100%;
                overflow:auto;
            }
            *{
                margin:0;
                padding:0;
            }
            #footer1{
                margin-top: 2px;
                bottom:0;
            }
            #productdetails{
                float:right;
            }
            table{
               float:right;
                margin-top: 180px;
                margin-left: 1%;
                margin-bottom: 2%;         
                width: 990px;
            }
            td{
               width:330px; 
            }
            #buybutton
            {
                background-color: #FFFF66;
                height: 40px;
                width:80px;
                text-align: center;
                font-weight: bold;
                border-radius: 5px;
                border:2px solid black;
            }
        </style>
    </head>
    <body>
        <div id="header1">
            <% if (session.getAttribute("firstname") == null) {%>
            <jsp:include page="Header.html"/>
            <% } else {%>

            <header id="head">
                <img src="logo.png"/>
                <h1 id="name"><strong>MITESH MOBILE & ELECTRONICS</strong></h1>  
                <div id="headcart">
                    <h4 style="margin-right: 30px">Hello, <c:out value="<%=session.getAttribute("firstname")%>"/></h4> &nbsp; &nbsp; 
                    <a href="##"><img src="cart1.png" id="cart"/></a>  
                </div>
                <div id="navbarid"></div>
                <script>
                    $("#navbarid").load("navigation.html");
                </script>
            </header>
            <%}%> 
        </div> 
        <div style="float:left;">
            <jsp:include page="sidenavbar06.jsp"/>
        </div>
            <c:set var="cat_id" value="${param.category_id}"/>
        <div id="productdetails" style="margin-top: 10px;">
            <sql:setDataSource var="productdisplay" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mitesh_electronics?useSSL=FALSE" user="root" password="root" scope="session"/>
            <%if (request.getParameter("page").equals("accessories")) {%>
            <sql:query dataSource="${productdisplay}" var="productQuery">
                select * from product_master where category_id = (select category_id from category_master where category_name = "Accessories");
            </sql:query>
            <form method="post" action="AddToCart">
                
                <table border="2" cellspacing="5px" cellpadding="10px">
                    <c:forEach var="row" items="${productQuery.rows}" varStatus="count">
                        <c:if test="${count.index%3==0}">
                        <tr>
                        </c:if>
                            <td align="center">
                                    <img src="${pageContext.servletContext.contextPath }/ElectronicsImageServlet?id=${row.product_id}" height="200" id="imageview"/><br/>
                                    <h4><b><c:out  value="${row.product_name}"/></b></h4>
                                    <c:out  value="${row.description}"/><br/>
                                    <b>Price: <c:out  value="${row.price}"/></b><br/><br/>
                                    <input type="button" value="Buy" name="buying" id="buybutton">
                                     <br/>                                      <br/>
                                </td>
                                
                                <c:if test="${count.index%3==2}">
                        </tr>
                                </c:if>

                    </c:forEach>
                </table>
            </form>
            <%} else {
                
                }%>
        </div>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>

    </body>
</html>
