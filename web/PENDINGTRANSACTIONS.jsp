<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="back.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="PENDINGTRANSACTIONS.css">
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
                    <th>Amount</th>
                    <th>Payment mode</th>
                    <th>Transaction detail</th>
                    <th>Transaction status</th>
                    </th>
                </tr>
                <%                    
                        Statement st=DB.databaseconnection();
                        ResultSet rs=st.executeQuery("Select * from Orderdetail where Transactionstatus='Pending'");
                        Boolean record=rs.next();
                        if(record==true)
                        {
                            while(record==true)
                            {
                                out.print("<tr>"
                                        + "<td>"+rs.getInt("Id")+"</td>"
                                                + "<td>"+rs.getString("Orderstatus")+"</td>"
                                                + "<td>"+rs.getInt("Amount")+"</td>"
                                                        + "<td>"+rs.getString("Paymentmode")+"</td>"
                                                                + "<td>"+rs.getString("Transactiondetail")+"</td>"
                                                                        + "<td>"+rs.getString("Transactionstatus")+"</td>"
                                        + "</tr>");
                                record=rs.next();
                            }
                        }
                        else
                        {
                            out.print("<p id='MESSAGE'>No any order with Pending Transaction.</p>");
                        }
                    %>
            </table>
        </div>
            <div id="TRANSACTIONSTATUSMODIFICATIONSECTION">
                <form action="TRANSACTIONSTATUSMODIFICATION" method="POST">
                <h3 class="INNERHEADINGS">Transactionstatus Modification</h3>
                <table>
                    <tr>
                        <td>Enter Order id</td><td><input type="text" name="ORDERID"></td>
                    </tr>
                    <tr>
                        <td>Enter Transaction detail</td><td><input type="text" name="TRANSACTIONDETAIL"></td>
                    </tr>
                    <tr>
                        <td>Transaction status</td><td><input class="RADIO" type="radio" name="TRANSACTIONSTATUS" value="PENDING">Pending<input class="RADIO" type="radio" name="TRANSACTIONSTATUS" value="SUCCESS">Success</td>
                    </tr>
                </table>
                <button class="MODIFY" type="submit">Modify</button><button class="RESET" type="reset">Reset</button>
            </form>
            
        </div>
            
    </body>
</html>
