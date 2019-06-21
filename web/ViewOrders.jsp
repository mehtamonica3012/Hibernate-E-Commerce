<%-- 
    Document   : ViewOrders
    Created on : Jun 17, 2019, 3:23:37 PM
    Author     : Monica Mehta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Orders Page</title>
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
            .anchor{  
                margin-top: 2px;
                height:514px;
                visibility:visible;
                width:100%;
                left:0;
                background-color: #CCC;
                right:0;               
                padding-top:0px;
                padding:0px;
                position:relative;
                display:block;
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
                margin-top: 40px;

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
            #headcart .logout
            {
                margin-top: 40px;
            }
            #headcart .logout a
            {
                text-decoration: none; 
                color:white; 
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

                bottom:0;
            }
            #cartproduct
            {
                width:100%;
                height:100%;
            }
            #headcart #navbar1
            {
                margin-left: 44%;
                position:relative;
                float: right;
            }
            #navbar1 ul{
                list-style: none;
                float:right;

            }
            #navbar1 ul li h4{
                background-color: none;
                width: auto;
                height:30px;
                line-height: 10px;
                text-align: center;
                float:left;
                color: white;
                font-size: 18px;
                font-weight: bold;
                position:relative;
            }

            #navbar1 ul li  a{
                text-decoration: none;
                color:black;
                font-weight: bold;
            }

            #navbar1 ul li:hover > ul{
                display:block;

            }
            #navbar1 ul ul{
                align-self: flex-end;
                display:none;
                top:0px;
                margin-left: 30px;
                position:absolute;
                margin-top: 77px;
                z-index:1;
            }
            #dropUsername li{
                border: 1px inset white;
                padding: 10px;
                background: #f4f5f5;
            }
            i {
                border: solid white;
                border-width: 0 3px 3px 0;
                display: inline-block;
                padding: 3px;
                margin-bottom: 4px;
                transform: rotate(45deg);
            }
            table{
                margin-top: 200px;
                margin-bottom: 2%;         
                width: 100%;
            }
            td{
                width:20%;
                vertical-align: middle;
                padding:10px;
            }
            #qty{
                height: 25px;
                width:25px;
                padding: 2px;
                border-radius: 15px;
                font-size: 20px;
                text-align: center;
            }
            #payment{
                background-color: #0570FF;
                font-size: 20px;
                padding: 14px 40px;
                border-radius: 12px;
                border-style: none;
                color:white;
                font-style: bold;
            }
            #payment:hover{
                box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            }
        </style>
    </head>
    <body>
        <div id="header1">
            <% if (session.getAttribute("firstname") == null) {%>
            <header id="head">
                <jsp:include page="Header.html"/>
            </header>
            <% } else {%>

            <header id="head">
                <img src="logo.png"/>
                <h1 id="name"><strong>MITESH MOBILE & ELECTRONICS</strong></h1>  
                <div id="navbar1">
                    <ul>
                        <li>

                            <h4 style="margin-right: 30px; margin-top:45px; cursor:default;">Hello, <c:out value="<%=session.getAttribute("firstname")%>"/> &nbsp;<i></i></h4> &nbsp; &nbsp; 
                            <ul id="dropUsername">
                                <li>

                                    <a href="${pageContext.servletContext.contextPath}/ViewOrders.jsp">View Orders</a>
                                </li>
                                <li>

                                    <a href="${pageContext.servletContext.contextPath}/Logout">Logout</a>
                                </li>
                            </ul>
                        </li>
                    </ul>

                </div>
                <a href="Cart.jsp"><img src="cart1.png" id="cart"/></a>  

                <div id="navbarid"></div>
                <script>
                    $("#navbarid").load("navigation.html");
                </script>
            </header>
            <%}%> 
        </div>
        <div id="orderdetails" style="margin-top: 10px;">
            <sql:setDataSource var="cartdisplay" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mitesh_electronics?useSSL=FALSE" user="root" password="root" scope="page"/>
            <sql:query dataSource="${cartdisplay}" var="vieworder">
                select om.order_id,om.date_time,om.is_delivered,od.order_detai_id,od.product_id,od.quantity,od.price,pd.product_name from order_master om,order_detail od,product_master pd where om.order_id=od.order_id and od.product_id=pd.product_id and om.customer_id = <%=session.getAttribute("custid")%>;
            </sql:query>

            <form method="get" action="Order">
                <table border="0" cellspacing="5px" cellpadding="10px">
                    <c:set var="total" value="0"></c:set>
                    <c:forEach var="row" items="${vieworder.rows}" varStatus="count">

                        <tr>
                            <td align="center">
                                <img src="${pageContext.servletContext.contextPath }/ElectronicsImageServlet?id=${row.product_id}" height="200" id="imageview"/>
                            </td>
                            <td align="center">
                                <h3><b><c:out  value="${row.product_name}"/></b></h3>
                            </td>        
                            <td valign="middle" align="center">
                                <b>Price: <c:out  value="${row.price}"/></b>
                            </td>
                            <td align="center">
                                <b>Quantity:</b> <input type="text" name="quantity" disabled="true" id ="qty" value="${row.quantity}" /> &nbsp;

                            </td>
                            <td align="center">
                                <c:choose>
                                    <c:when test="${row.is_delivered == 'D'}">
                                        <img src="payment/images.png" height="100px"/>
                                        <br> Delivered
                                    </c:when>
                                    <c:otherwise>
                                        <img src="payment/truck.png" height="100px"/>
                                        <br>In process
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>


                </table>

            </form>

        </div>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>
    </body>
</html>
