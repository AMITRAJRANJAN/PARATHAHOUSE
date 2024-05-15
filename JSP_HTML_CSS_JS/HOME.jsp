<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="back.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="HOME.css">
    </head>
    <body>
        <%!
            Database DB=new Database();
            %>
        
        <%@include file="USERHEADER.jsp" %>
        <form action="ORDER1">
            <br>
            <br>
            <h2 id="ORDERFORMHEADING">Make an order :</h2>
        <div id="PARATHASELECTORSECTION">
            <h2 class="INNERHEADINGS">Select Your Paratha</h2>
            <table>
            <tr>
            <td>
            <select id="PARATHASELECTOR" name="PARATHASELECTOR">
                <option>Select</option>
                <%
                    Statement st=DB.databaseconnection();
                    ResultSet rs=st.executeQuery("Select * from Paratha");
                    Boolean record=rs.next();
                    if(record==true)
                    {
                        while(record==true)
                        {
                            out.print("<option value="+rs.getString("Name")+">"+rs.getString("Name")+" Paratha"+"</option>");
                            record=rs.next();
                        }
                    }
                    %>
            </select>
            </td>
            <td>
            <button>Search Paratha</button>
            </td>
            </tr>
            </table>       
        </div>
        </form>
        <%
            String currentuser=session.getAttribute("CURRENTUSER").toString();
            out.print("<h3 id='CURRENTUSER'>Hello Mr. "+currentuser+"&emsp;<a href='LOGOUT'>Logout</a></h3>");
        %>
        
    </body>
</html>
