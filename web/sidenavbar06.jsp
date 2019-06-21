<%-- 
    Document   : sidenavbar06
    Created on : 22 Nov, 2018, 2:24:32 PM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sidenavbar Page</title>
        <style>
            li{
                list-style: none;
            }
            .mainnav{
                width:265px;
                background: graytext;
                border:2px solid black;
                position:relative;
                margin-top:190px;
            }
            .mainnav li{
                text-transform: uppercase;
                letter-spacing: .1em;
                color:white;
                display:block;
                padding:10px 0px 10px 20px;
                border-bottom:2px solid white;
                
            }
            .mainnav li:hover{
                background:rgba(121,165,162,1.00);
            }
            .mainnavul ul{
                display:block;
                /*margin-left:-40px;*/
               
            }
          /* .mainnavul li:hover ul{
                display:block;
            }
           */
        </style>
    </head>
    <body>
            <sql:setDataSource var="sidenavdatasrc" driver="com.mysql.jdbc.Driver" user="root" password="root" url="jdbc:mysql://localhost:3306/mitesh_electronics?useSSL=False" scope="page"/>
            <nav class="mainnav">
                <form action="Sidenavbar11" method="get">
                <h2><b><center>Filters</center></b></h2>
                <ul class="mainnavul">
                    <li>Filter by Price<span></span>
                        <ul>
                            <li><input type="checkbox" name="chk1" value="1500-5000" />1500-5000</li>
                             <li><input type="checkbox" name="chk1" value="5000-10000"/>5000-10000</li>
                             <li><input type="checkbox" name="chk1" value="10000-15000"/>10000-15000</li>
                             <li><input type="checkbox" name="chk1" value="15000 & above"/>15000 & Above</li>
                        </ul>
                    </li>
                    <li>Filter by Brand<span></span>
                        <sql:query dataSource="${sidenavdatasrc}" var="selectbrand">
                            select * from brand_master;
                        </sql:query>
                        <ul>
                            <c:forEach var="row" items="${selectbrand.rows}">
                                <li><input type="checkbox" name="chkbrand" value="<c:out value="${row.brand_id}"/>"><c:out value="${row.brand_name}"/></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li>Filter by Discounts<span></span>
                        <ul>
                            <li><input type="checkbox" name="chkd1" value="0-10"/>0%-10%</li>
                            <li><input type="checkbox" name="chkd1" value="11-20"/>11%-20%</li>
                            <li><input type="checkbox" name="chkd1" value="21-30"/>21%-30%</li>
                            <li><input type="checkbox" name="chkd1" value="31-40"/>31%-40%</li>
                        </ul>
                    </li>
                    <li>
                        <center><input align="center" type="submit" value="SUBMIT" style="margin-left:-25px"></center>
                    </li>
                </ul>
            </nav>
            
            <input type="hidden" name="category" value="${param.category}">
            <input type="hidden" name="sub_category" value="${param.sub_category}">
        </form>
                
    </body>
</html>
