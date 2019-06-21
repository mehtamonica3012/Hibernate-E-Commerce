<%-- 
    Document   : signup123
    Created on : 19 Nov, 2018, 2:24:55 AM
    Author     : Monica Mehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function div_signup() {
            document.getElementById('signup').style.display = "block";
            }
            window.onload=function(){
                div_signup();
            };
            
                $(document).ready(function(){
                    setTimeout(function(){
                       div_signup();
                    },5000); // 5000 to load it after 5 seconds from page load
                 });
           
            function div_hidesignup(){
            //document.getElementById('closebtn').this.parentNode.style.display = "none";
            document.getElementById('closebtn1').addEventListener('click', function(e) {
                    e.preventDefault();
                    this.parentNode.parentNode.parentNode.style.display = 'none';
                }, false);
                window.location.href = "HomePage.jsp";
            }
            
        </script>
        <style>
            #signup {
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
            div #popupsignup {
                position:absolute;
                left:35%;
                top:20%;
                height:500px;
                width:fit-content;
                background: linear-gradient(#5614B0,#DBD65C);
                z-index: 20;
                border-radius: 2%;
                border: 2px solid black;
                font-family:'Raleway',sans-serif
            }
            #closebtn1
            {
                position:absolute;
                right: -16px;
                top: -16px;
                cursor:pointer;
                height:50px;
                width:50px;
                display: block;
            }
            div #popupsignup table{
                background-color: snow;
                margin-inline-start: 20px;
                margin-inline-end: 20px;
                margin-top:-10px;
                border-radius: 2%;
                padding:10px;
            }
        </style>
    </head>
    <body onload="div_signup()">
        <div id="signup">
            <div id="popupsignup">
                

                <center>
                    <img id="closebtn1" src="closebutton.png" onclick ="div_hidesignup()"/>
                    <table border="0" cellspacing="2px" cellpadding="5px">
                    <form method="post" action="signup12">
                        <caption style=" margin-top: 4px;"><h2 align="center">Registration</h2></caption>
                        
                            <b>
                                <tr>
                                    <td align="center">
                                        FirstName: 
                                    </td>
                                    <td align="center">
                                        <input type="text" name="fname" pattern="[A-Za-z]+"
                                                        title="Enter Valid FirstName" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        LastName:
                                    </td>
                                    <td align="center">
                                        <input type="text" name="lname" pattern="[A-Za-z]+"
                                                        title="Enter Valid LastName" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        Contact:
                                    </td>
                                    <td align="center">
                                        <input type="number" name="contak" pattern="[26789][0-9]{9}" maxlength="10" title="Enter the contact starting with 7/8/9 and followed by more 9 digits" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        Address Line1:
                                    </td>
                                    <td align="center">
                                        <input type="text" name="addline1" title="Enter address in format Flat no.,Bldg name,Local area name" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        Address Line2:
                                    </td>
                                    <td align="center">
                                        <input type="text" name="addline2" title="Enter city" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        Address Line3:
                                    </td>
                                    <td align="center">
                                        <input type="text" name="addline3" title="Enter state" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        PINCODE:
                                    </td>
                                    <td align="center">
                                        <input type="number" name="pin" pattern="[0-9]{5}" maxlength="6" title="Enter a valid Pincode" required/>
                                    </td>
                                </tr>
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
                                        <input type="password" name="pswd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">
                                        Confirm Password:
                                    </td>
                                    <td align="center">
                                        <input type="password" name="cnpswd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td align="start">
                                        <input type="submit" value="SUBMIT"/>
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
