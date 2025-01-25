<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="back.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="DELIVEREDORDERS.css">
    </head>
    <body>
        <%!
            Database DB=new Database();
            %>
            <%@include file="USERHEADER.jsp" %>
        <br>
        <br>
        <br>
        <div id="ORDERDETAILSECTION">
            <table>
                <tr>
                    <th>Order id</th>
                    <th>Order status</th>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Amount</th>                 
                    <th>Delivery address</th>
                    <th>Pincode</th>
                    <th>Contact</th>
                    <th>Delivery status</th>
                  
                </tr>
                <%       
                        String currentuser=session.getAttribute("CURRENTUSERNAME").toString();
                        Statement st=DB.databaseconnection();
                        ResultSet rs=st.executeQuery("Select * from Orderdetail where Username='"+currentuser+"' AND Deliverystatus='Delivered'");
                        Boolean record=rs.next();
                        if(record==true)
                        {
                            while(record==true)
                            {
                                out.print("<tr>"
                                        + "<td>"+rs.getInt("Id")+"</td>"
                                           + "<td>"+rs.getString("Orderstatus")+"</td>"
                                                + "<td>"+rs.getString("Item")+" Paratha</td>"
                                                         + "<td>"+rs.getInt("Quantity")+"</td>"
                                                                  + "<td>"+rs.getInt("Amount")+"</td>"
                                                                                                        + "<td>"+rs.getString("Deliveryaddress")+"</td>"
                                                                                                                 + "<td>"+rs.getInt("Pincode")+"</td>"
                                                                                                                            + "<td>"+rs.getString("Contact")+"</td>"
                                                                                                                                      + "<td>"+rs.getString("Deliverystatus")+"</td>"
                                        + "</tr>");
                                record=rs.next();
                            }
                        }
                        else
                        {
                            out.print("<p id='MESSAGE'>No any order.</p>");
                        }
                    %>
            </table>
        </div>
            
    </body>
</html>
