<%-- 
    Document   : electronics06
    Created on : 18 Nov, 2018, 4:08:46 AM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>${param.category}</title>
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
                margin-top: 40px;

            }
            #headcart h4 a{
                text-decoration: none;
                color:white;  
                rmargin-right: 15px;
                vertical-align: middle;
            }
            #headcart{
                vertical-align: middle;
                margin-right: 20px;
                height: 40px;
                float:right;
            }
            #headcart #logout
            {
                margin-top: 40px;
            }
            #headcart #logout a
            {
                text-decoration: none; 
                color:white; 
                float:right; 

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
            #formid table{
                float:right;
                margin-top: 180px;

                margin-bottom: 2%;         
                width: 1240px;
            }
            #formid td{
                width:413px; 
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
                text-decoration: none;
                color:black;
                padding: 10px;
                visibility: visible;
            }
            #buybutton1
            {
                background-color: grey;
                height: 40px;
                width:80px;
                text-align: center;
                font-weight: bold;
                border-radius: 5px;
                border:2px solid black;
                text-decoration: none;
                color:black;
                padding: 10px;
                visibility: visible;
                enabled:false;
                pointer-events: none;
                cursor: default;
            }
            button{                

                visibility: hidden;
            }
            td{
                height:auto;
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
        <div style="float:left;">
            <jsp:include page="sidenavbar06.jsp"/>
        </div>
        <c:set var="category" value="${param.category}"/>
        <c:set var="sub_category" value="${param.sub_category}"/>

        <div id="productdetails" style="margin-top: 10px;">
            <sql:setDataSource var="productdisplay" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mitesh_electronics?useSSL=FALSE" user="root" password="root" scope="session"/>

            <sql:query dataSource="${productdisplay}" var="productQuery">
                <%=request.getAttribute("query")%>         
            </sql:query>


            <form method="get" action="##" id="formid">

                <table border="2" cellspacing="5px" cellpadding="10px">
                    <c:forEach var="row" items="${productQuery.rows}" varStatus="count">
                        <c:set var="product_Id" value="${row.product_id}"/> 
                        <c:if test="${count.index%3==0}">
                            <tr>
                            </c:if>
                            <td align="center">
                                <br/>
                                <img src="${pageContext.servletContext.contextPath }/ElectronicsImageServlet?id=${row.product_id}" height="200" id="imageview"/><br/><br/>
                                <h4><b><c:out  value="${row.product_name}"/></b></h4>
                                <c:out  value="${row.description}"/><br/>
                        <strike><b>Price: <c:out  value="${row.price}"/></b></strike><br/>
                        <b style="color:blueviolet;">Discount Applied: <c:out value="${row.category_discount}"/>%</b><br/>
                        <b>Discounted Price: <c:out value="${row.price-(row.price*row.category_discount/100)}"/></b><br/><br/>

                        <c:choose>
                            <c:when test="${row.in_stock!=0}">

                                <button type="submit" value="Add to Cart"> <a href="${pageContext.servletContext.contextPath }/AddToCart?prid=${row.product_id}&category=${param.category}&sub_category=${param.sub_category}" id="buybutton">Add to Cart</a></button>
                            </c:when>

                            <c:otherwise>
                                <b style="color:red;"> Out of stock </b><br/><br/>
                                <button type="submit" disabled="true"> <a href="${pageContext.servletContext.contextPath }/AddToCart?prid=${row.product_id}&category=${param.category}&sub_category=${param.sub_category}" id="buybutton1" >Add to Cart</a></button>
                            </c:otherwise>
                        </c:choose>

                        <br/>                                      <br/>
                        </td>

                        <c:if test="${count.index%3==2}">
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
        <!--                        <input type="hidden" name="productid" value="${product_Id}"/>-->
                <input type="hidden" name="category" value="${category}"/>
                <input type="hidden" name="subcategory" value="${sub_category}"/>

            </form>

        </div>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>
    </body>
</html>
