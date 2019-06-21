<%-- 
    Document   : Order
    Created on : Jun 12, 2019, 3:53:12 PM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Order Page</title>
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
                width:25%;
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
            <sql:setDataSource var="cartdisplay" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mitesh_electronics?useSSL=FALSE" user="root" password="root" scope="session"/>
            <sql:query dataSource="${cartdisplay}" var="cartquery">
                select c.cart_id,p.product_id,p.product_name,p.price,c.quantity,p.category_discount,p.price-(p.price*p.category_discount/100) as discounted_price,p.in_stock from product_master p inner join cart c on p.product_id=c.product_id where c.customer_id = <%=session.getAttribute("custid")%>
            </sql:query>
            <form method="get" action="Order">
                <table border="0" cellspacing="5px" cellpadding="10px">
                    <c:set var="total" value="0"></c:set>
                    <c:forEach var="row" items="${cartquery.rows}" varStatus="count">
                        <c:set var="product_Id" value="${row.product_id}"/> 
                        <tr>
                            <td align="center">
                                <h3><b><c:out  value="${row.product_name}"/></b></h3>
                            </td>        
                            <td valign="middle">
                        <strike><b>Price: <c:out  value="${row.price}"/></b></strike><br/>
                        <b style="color:blueviolet;">Discount Applied: <c:out value="${row.category_discount}"/>%</b><br/>

                        <b>Discounted Price: <c:out value="${row.discounted_price}"/></b>
                        <input type="hidden" name="discountprice" value="${row.discounted_price}"/>
                        <input type="hidden" name="prodid" value="${row.product_id}"/>
                        <input type="hidden" name="quantity" value="${row.quantity}"/>
                        </td>
                        <td align="center">
                            <b>Quantity:</b> <input type="text" name="quantity" disabled="true" id ="qty" value="${row.quantity}" /> &nbsp;

                        </td>
                        <td align="center">
                            <h3 style="display:inline;">Total Price <c:out value="${row.discounted_price * row.quantity}"></c:out></h3>
                            </td>

                            </tr>
                        ${total=total+row.discounted_price}
                    </c:forEach>
                    <tr>
                        <td colspan="3" align="right">
                            <h3>Cart Total:  </h3>
                        </td>
                        <td>
                            <h3>₹<c:out value="${total}"/></h3>
                        </td>
                    </tr>
                    <input hidden="cart_total" value="${total}" name="cart_total"/>
                    <tr>
                        <td colspan="4" align="center">
                            <input id="payment" type="submit" value="Make Payment" onclick="confirmorder()"/>
                        </td>
                    </tr>

                </table>
                <script>
                    function confirmorder()
                    {
                        alert("Are you sure ? \nDo you want to confirm order?");
                    }
                </script>
            </form>

        </div>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>
    </body>
</html>
