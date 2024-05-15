<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="ORDER2.css">
    </head>
    <body>
            <%@include file="USERHEADER.jsp" %>
        <%
            String selectedparatha=session.getAttribute("SELECTEDPARATHA").toString();
            String selectedparatharate=session.getAttribute("SELECTEDPARATHARATE").toString();
            String parathaquantity=session.getAttribute("QUANTITY").toString();
           
                int paratharate=Integer.parseInt(selectedparatharate);
                int quantity=Integer.parseInt(parathaquantity);
                int totalamount=paratharate*quantity;
            
            session.setAttribute("TOTALAMOUNT",totalamount);
            
        %>
        <form action="ORDER3">
        <h2 id="ORDERSECTION">Order details :</h2>
        <div id="ORDERDETAILSECTION">
        <div class="ORDERDETAIL" id="PARATHASECTION">
            <h2 class="INNERHEADINGS">Paratha</h2>
            <%
                out.print("<input disabled value="+selectedparatha+"&nbsp;Paratha>");
            %>
        </div>
        <div class="ORDERDETAIL" id="RATESECTION">
            <h2 class="INNERHEADINGS">Rate</h2>
            <%
                out.print("<input disabled value=Rs&nbsp;"+selectedparatharate+">");
                %>
        </div>
        <div class="ORDERDETAIL" id="QUANTITYSECTION">
            <h2 class="INNERHEADINGS">Quantity</h2>
            <%
                out.print("<input disabled value="+quantity+"> ");
                %>
        </div>
        <div class="ORDERDETAIL" id="TOTALAMOUNTSECTION">
            <h2 class="INNERHEADINGS">Total Amount</h2>
            <%
                out.print("<input disabled value="+totalamount+" name='AMOUNT'> ");
                %>
        </div>
        </div>
        <h2 id="DELIVERYSECTION">Delivery details :</h2>
        <div id="DELIVERYDETAILSECTION">
        <div class="DELIVERYDETAIL" id="DELIVERYADDRESSSECTION">
            <h2 class="INNERHEADINGS">Delivery Address</h2>
            <input type="text" name="DELIVERYADDRESS">
        </div>
        <div class="DELIVERYDETAIL" id="PINCODESECTION">
            <h2 class="INNERHEADINGS">Pincode</h2>
            <input type="text" name="PINCODE">
        </div>
        <div class="DELIVERYDETAIL" id="CONTACTSECTION">
            <h2 class="INNERHEADINGS">Contact</h2>
            <input type="text" name="CONTACT">
        </div>
            <button id="PROCEEDTODELIVERY">Proceed to Delivery</button>
            </div>
        </form>
    </body>
</html>
