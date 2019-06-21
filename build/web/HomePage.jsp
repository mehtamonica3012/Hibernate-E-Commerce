<%-- 
    Document   : HomePage
    Created on : 1 Nov, 2018, 1:32:25 AM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js?ver=1.3.2'></script>
        <script type='text/javascript' src='/js/jquery.mousewheel.min.js'></script>--%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>HomePage Page</title>
        <style>
            /*            #prod{
                            height:500px;
                            width:100%;
                            left:0;
                            background-color: #CCC;
                            right:0;     
                            margin-top:5px;
                            padding-top:0px;
                            position:relative;
                        }*/
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
            .anchor{  
                margin-top: 2px;
                height:240px;
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
                float: right;
                margin-right: 15px;
                vertical-align: middle;

            }
            #headcart{
                vertical-align: middle;
                margin-right: 20px;
                height: auto;
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


        </style>
    </head>
    <body>
        <div id="header">
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
        <a href="Sidenavbar11?category=All" style="text-decoration: none;color:black;">
            <%@include file="trialcarouselcss.html"%>
        </a>

        <!--        <section id="prod">hello
                </section>-->

        <%@include file="electronics.html"%>



        <%@include file="accessories.html"%>



        <%@include file="products.html"%>

        <section class="anchor" id="aboutussection">

            <h1 align="center" style="font-size:35px; font-weight:bold;" class="aboutuscontent"><b><u>About Us</u></b></h1>  
            <p style="font-size:24px; text-align:center;" id="about">Welcome to <span style="color: #9C031C;">Mitesh Mobile & Electronics</span>, your number one source for all things product <span style="color: #9C031C;">i.e. Phones, Laptops, Accessories etc</span>. We're dedicated to giving you the very best of products, with a focus on three characteristics, ie: dependability, customer service and uniqueness.
                Founded in 2009 by Mr. Mannalal Mehta, <span style="color: #9C031C;">Mitesh Mobile & Electronics</span> has come a long way from its beginnings in Business. When Mannalal Mehta first started out, his passion for Learning new things/new Technologies drove him to do intense research, and gave him the impetus to turn hard work and inspiration into to a booming online store. We now serve customers all over in India, and are thrilled to be a part of the quirky, eco-friendly, fair trade wing of the Telecommunications industry.</p>
        </section>
        <div id="footer1">
            <%@include file="Footer.html"%>
        </div>
    </body>
</html>
