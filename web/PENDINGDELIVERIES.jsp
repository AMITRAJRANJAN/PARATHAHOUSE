<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="back.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="PENDINGDELIVERIES.css">
    </head>
    <body>
        <%!
            Database DB=new Database();
            %>
       <%@include file="ADMINHEADER.jsp" %>
        <br>
        <br>
        <br>
        <div id="ORDERDETAILSECTION">
            <table>
                <tr>
                    <th>Order id</th>
                    <th>Order status</th>
                    <th>User</th>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Delivery address</th>
                    <th>Pincode</th>
                    <th>Contact</th>
                    <th>Delivery status</th>
                </tr>
                <%                    
                        Statement st=DB.databaseconnection();
                        ResultSet rs=st.executeQuery("Select * from Orderdetail where Deliverystatus='Pending'");
                        Boolean record=rs.next();
                        if(record==true)
                        {
                            while(record==true)
                            {
                                out.print("<tr>"
                                        + "<td>"+rs.getInt("Id")+"</td>"
                                                + "<td>"+rs.getString("Orderstatus")+"</td>"
                                                + "<td>"+rs.getString("User")+"</td>"
                                                        + "<td>"+rs.getString("Item")+" Paratha</td>"
                                                                + "<td>"+rs.getInt("Quantity")+"</td>"
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
                            out.print("<p id='MESSAGE'>No any order with Pending Deliveries.</p>");
                        }
                    %>
            </table>
        </div>
            <div id="DELIVERYSTATUSMODIFICATIONSECTION">
                <form action="DELIVERYSTATUSMODIFICATION" method="POST">
                <h3 class="INNERHEADINGS">Deliverystatus Modification</h3>
                <table>
                    <tr>
                        <td>Enter Order id</td><td><input type="text" name="ORDERID"></td>
                    </tr>
                    <tr>
                        <td>Enter Contact</td><td><input type="text" name="CONTACT"></td>
                    </tr>
                    <tr>
                        <td>Delivery status</td><td><input class="RADIO" type="radio" name="DELIVERYSTATUS" value="PENDING">Pending<input class="RADIO" type="radio" name="DELIVERYSTATUS" value="DELIVERED">Delivered</td>
                    </tr>
               </table>
                <button class="MODIFY" type="submit">Modify</button><button class="RESET" type="reset">Reset</button>
            </form>
            
        </div>
        
    </body>
</html>
