<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="back.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ORDER3.css">
    </head>
    <body>
        <%!
            Database DB=new Database();
            %>
            <%
               Statement st=DB.databaseconnection();
               ResultSet rs=st.executeQuery("Select Id from Orderdetail");
               Boolean record=rs.next();
               int orderid=0;
               if(record==true)
               {
                   while(record==true)
                   {
                       orderid=rs.getInt("Id");
                       record=rs.next();
                   }
                   orderid=orderid+1;
               }
               else
               {
                   orderid=10001;
               }
               session.setAttribute("ORDERID",orderid);
            %>
        <%
            String selectedparatha=session.getAttribute("SELECTEDPARATHA").toString();
            String selectedparatharate=session.getAttribute("SELECTEDPARATHARATE").toString();
            String parathaquantity=session.getAttribute("QUANTITY").toString();
            String totalamount=session.getAttribute("TOTALAMOUNT").toString();
            String deliveryaddress=session.getAttribute("DELIVERYADDRESS").toString();
            String pincode=session.getAttribute("PINCODE").toString();
            String contact=session.getAttribute("CONTACT").toString();
            %>
            
        <%@include file="USERHEADER.jsp" %>
            <br>
            <br>
            <table id="ORDERDETAIL">
                <tr><td><h2>Order Details</h2></td></tr>
                <tr>
                    <td>
                        <%
                            out.print("<input disabled value='Orderid:&emsp;"+orderid+""
                                    + "&emsp;&emsp;&emsp;Paratha :&emsp;"+selectedparatha+" Paratha "
                                    + "&emsp;&emsp;&emsp;Quantity :&emsp;"+parathaquantity+""
                                            + "&emsp;&emsp;&emsp;Rate :&emsp;Rs"+selectedparatharate+""
                                                    + "&emsp;&emsp;&emsp;Total Amount :&emsp;Rs "+totalamount+"'>");
                        %>
                    </td>
                </tr>
                <tr><td><h2>Delivery Details</h2></td></tr>
                <tr>
                    <td>
                        <%
                            out.print("<input disabled value='Address :&emsp;"+deliveryaddress+" Paratha "
                                    + "&emsp;&emsp;&emsp;Pincode :&emsp;"+pincode+""
                                                    + "&emsp;&emsp;&emsp;Contact :&emsp;"+contact+"'>");
                        %>
                    </td>
                </tr>
            </table>
         <form action="ORDER4">
            <br>
            <h2 id="PAYMENTFORMHEADING">Make payment :</h2>
            <div class="PAYMENTBLOCK" id="PAYMENTMODESECTION">
            <h2 class="INNERHEADINGS">Select Your Payment Mode</h2>
            <select id="PAYMENTMODESELECTOR" name="PAYMENTMODESELECTOR">
                <option value="SELECT">Select</option>
                <%
                        Statement st2=DB.databaseconnection();
                        ResultSet rs2=st2.executeQuery("Select * from Paymentmode");
                        Boolean record2=rs2.next();
                        if(record2==true)
                        {
                            while(record2==true)
                            {
                                out.print("<option value='"+rs2.getString("Name")+"'>"+rs2.getString("Name")+"</option>");
                                record2=rs2.next();
                            }
                        }
                    %>
            </select>
            <button>Proceed</button>
        </div>
         </form>
   
                
    </body>
</html>
