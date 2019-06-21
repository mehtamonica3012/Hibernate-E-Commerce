<%-- 
    Document   : login123
    Created on : 19 Nov, 2018, 12:19:26 AM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
        
        <script>
            function div_login() {
            document.getElementById('login').style.display = "block";
            }
            window.onload=function(){
                div_login();
            };
            
                $(document).ready(function(){
                    setTimeout(function(){
                       div_login();
                    },5000); // 5000 to load it after 5 seconds from page load
                 });
           
            function div_hidelogin(){
            //document.getElementById('closebtn').this.parentNode.style.display = "none";
            document.getElementById('closebtn').addEventListener('click', function(e) {
                    e.preventDefault();
                    this.parentNode.parentNode.parentNode.style.display = 'none';
                }, false);
                window.location.href = "HomePage.jsp";
            }
            
        </script>
        <style>
            #login {
                width:100%;
                height:100%;
                opacity:.95;
                top:0;
                left:0;
                display:none;
                position:fixed;
                background-color:#313131;
                overflow:auto;
                z-index: 20;
            }
            div #popuplogin {
                position:absolute;
                left:35%;
                top:20%;
                height:300px;
                width:fit-content;
                margin-top:10px;
                background: linear-gradient(#5614B0,#DBD65C);
                z-index: 20;
                border-radius: 2%;
                border: 2px solid black;
                font-family:'Raleway',sans-serif
            }
            #closebtn 
            {
                position:absolute;
                right: -18px;
                top: -15px;
                cursor:pointer;
                height:50px;
                width:50px;
                display: block;
            }
            div #popuplogin table{
                background-color: snow;
                margin-inline-start: 20px;
                margin-inline-end: 20px;
                margin-top: 20px;
                border-radius: 2%;
                padding:10px;
            }
        </style>
    </head>
    <body onload="div_login()">
        
        <div id="login"> 
            <div id="popuplogin">                 
         <!--   <h2 style="color:red"><b><center>Invalid email or password</center></b></h2>-->
                    <center>
                    <img id="closebtn" src="closebutton.png" onclick ="div_hidelogin()"/>
                    <table border="0" cellspacing="2px" cellpadding="5px">                  
                    <form method="post" action="login12">
                        <caption style="margin-bottom:20px"><h2 align="center">Login</h2></caption>
                            <b>
                                <tr>
                                    <td align="center">
                                       Email: 
                                    </td>
                                    <td align="center">
                                       <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Enter email in format abc12@something.com" required/> 
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                       Password: 
                                    </td>
                                    <td align="center">
                                       <input type="password" name="pswd" required/> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        
                                    </td>
                                    <td align="start">
                                        <input type="submit" value="LOGIN" align="center" />
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                <a href="signup123.jsp" style="color:blue;"> New User? </a>
                                    </td>
                                </tr>
                                
                            </b>
                        </center>
                    </form>    
                    </table>
            </div>
        </div>
        
    </body>
</html>
