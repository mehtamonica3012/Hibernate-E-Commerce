<%-- 
    Document   : payment
    Created on : Jun 13, 2019, 11:52:48 AM
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
        <title>Payment Page</title>
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
                /*                margin-top: 200px;*/
                margin-bottom: 2%;         
                width: 100%;
            }
            td{
                width:20%;
                vertical-align: middle;
                padding:10px;
            }
            #pimage
            {
                margin-top: 150px;
                valign:middle;
                align-self: center;
            }
            #ptmt b
            {
                font-size: 32px; font-style: italic; font-weight: bolder;
            }
            #sub{
                background-color: #0570BD;
                font-size: 20px;
                padding: 14px 40px;
                border-radius: 12px;
                color:white;
                font-style: bold;
            }
            #sub:hover{
                box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
            }
            #pay_details tr td
            {
                font-family: arial;
                font-size: 20px;
                color: #2c2c97;
                vertical-align: top;
                width:10%;
                padding-bottom: 30px;
            }
            input[type=number]{
                height: 20px;
                border-radius: 5px;
                border-style: ridge;
                padding:3px;
                font-size: 15px;
            }
            input[type=number]:focus,select:focus{
                outline: none;
            }
            input[type=number]::-webkit-inner-spin-button,input[type=number]::-webkit-outer-spin-button{
                margin:0;
                -webkit-appearance: none;
            }
            select{
                height: 30px;
                border-radius: 5px;
                border-style: solid;
                padding:3px;
                font-size: 15px;
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

                <div id="navbarid" style="display:block;"></div>
                <script>
                    $("#navbarid").load("navigation.html");
                </script>
            </header>
            <%}%> 
        </div>

        <div id="paymentpage">
            <div align="center" style="margin-top: 200px;" id="ptmt">

                <h3 style="font-weight: bolder; font-size:28px;"><span style="font-size:60px; font-family:Arial, Helvetica, sans-serif; font-weight:bolder;">P</span>AYMENT</h3>
                <br/>
                <form method="post" action="FinalPayment">
                    <table border="0" cellspacing="5px" cellpadding="10px">
                        <tr>
                            <td align="center" style="width:15%;vertical-align: top;">
                                <img src="payment/payment2.png" height="300px">
                            </td>
                            <td align="left">
                                <c:set value="${param.totalcart}" var="totalcart"/>
                                <table id="pay_details" cellpaddinh="0px" border="0">
                                    <tr>
                                        <td>
                                            Amount to be Paid: 
                                        </td>
                                        <td>
                                            <input type="number" style="background-color: white;align-content: center;" name="amt" disabled="true" value="${totalcart}"/> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Debit/Credit Card Number: 
                                        </td>
                                        <td>
                                            <input type="number" name="card"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            CVV: 
                                        </td>
                                        <td>
                                            <input type="number" name="cvv"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Card Expiry:
                                        </td>
                                        <td>
                                            Month:
                                            <select name="month">
                                                <c:forEach begin="1" end="12" var="mnth">
                                                    <option value="${mnth}">${mnth}</option>
                                                </c:forEach>
                                            </select>&nbsp;
                                            Year: 
                                            <select name="year">
                                                <c:forEach begin="2019" end="2029" var="year">
                                                    <option value="${year}">${year}</option>
                                                </c:forEach>
                                            </select>

                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2" align="center">
                                            <input type="submit" value="Submit" id="sub"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                    </table>
                </form>
            </div>
        </div>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>
    </body>
</html>
